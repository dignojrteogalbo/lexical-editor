// Composite(163): Composite
// Decorator(175): ConcreteComponent

package glyph.composition;

import glyph.Character;
import glyph.Glyph;
import glyph.compositor.Compositor;
import glyph.compositor.SimpleCompositor;
import util.Bounds;
import window.Window;
/**
 * This class implements a row composition.
 * 
 * @author Digno JR Teogalbo
 * @version CS472 Sp24
 */
public class Slant extends Composition {

    /**
     * Initializes a row composition from the provided window with the
     * HorizontalCompositor strategy.
     * 
     * @param window Window of the composition.
     */
    public Slant(Window window) {
        super(new SimpleCompositor(window));
    }

    public Slant(Compositor compositor) {
        super(compositor);
    }

    public Slant(String line, Compositor compositor) {
        super(compositor);
        int length = line.length();
        for (int i = 0; i < length; i++) {
            insert(new Character(line.charAt(i)), i);
        }
    }

    public Slant(String line, Window window) {
        super(new SimpleCompositor(window));
        int length = line.length();
        for (int i = 0; i < length; i++) {
            insert(new Character(line.charAt(i)), i);
        }
    }

    @Override
    public void adjust(Glyph child, Bounds cursor) {
        Bounds childBounds = child.getBounds();
        int cursorX = cursor.getX() + childBounds.getWidth();
        int cursorY = cursor.getY() + childBounds.getHeight();
        cursor.setPoint(cursorX, cursorY);
        int cursorWidth = cursor.getWidth() + childBounds.getWidth();
        int cursorHeight = cursor.getHeight() + childBounds.getHeight();
        cursor.setSize(cursorWidth, cursorHeight);
        bounds.setSize(cursorWidth, cursorHeight);
    }
}

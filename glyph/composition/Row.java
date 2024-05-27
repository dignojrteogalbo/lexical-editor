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
public class Row extends Composition {

    /**
     * Creates a row with a SimpleCompositor.
     * 
     * @param window Window to draw the row.
     */
    public Row(Window window) {
        super(new SimpleCompositor(window));
    }

    /**
     * Creates a row with the provided compositor.
     * 
     * @param Compositor Compositor to compose the row.
     */
    public Row(Compositor compositor) {
        super(compositor);
    }

    /**
     * Creates a row of characters from the provided string.
     * 
     * @param line       String to create character children from.
     * @param compositor Compositor to compose the row.
     */
    public Row(String line, Compositor compositor) {
        super(compositor);
        int length = line.length();
        for (int i = 0; i < length; i++) {
            insert(new Character(line.charAt(i)), i);
        }
    }

    /**
     * Creates a row of characters from the provided string. Uses the
     * SimpleCompositor to compose the row.
     * 
     * @param line       String to create character children from.
     * @param window Window to draw the row.
     */
    public Row(String line, Window window) {
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
        int cursorY = cursor.getY();
        cursor.setPoint(cursorX, cursorY);
        int cursorWidth = cursor.getWidth() + childBounds.getWidth();
        int cursorHeight = Math.max(cursor.getHeight(), childBounds.getHeight());
        cursor.setSize(cursorWidth, cursorHeight);
        bounds.setSize(cursorWidth, cursorHeight);
    }
}

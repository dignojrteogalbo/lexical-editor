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
 * This class implements a column composition.
 * 
 * @author Digno JR Teogalbo
 * @version CS472 Sp24
 */
public class Column extends Composition {

    /**
     * Creates a column with a SimpleCompositor.
     * 
     * @param window Window to draw the column.
     */
    public Column(Window window) {
        super(new SimpleCompositor(window));
    }

    /**
     * Creates a column with the provided compositor.
     * 
     * @param Compositor Compositor to compose the column.
     */
    public Column(Compositor compositor) {
        super(compositor);
    }

    /**
     * Creates a column of characters from the provided string.
     * 
     * @param line       String to create character children from.
     * @param compositor Compositor to compose the column.
     */
    public Column(String line, Compositor compositor) {
        super(compositor);
        int length = line.length();
        for (int i = 0; i < length; i++) {
            insert(new Character(line.charAt(i)), i);
        }
    }

    /**
     * Creates a column of characters from the provided string. Uses the
     * SimpleCompositor to compose the column.
     * 
     * @param line   String to create character children from.
     * @param window Window to draw the column.
     */
    public Column(String line, Window window) {
        super(new SimpleCompositor(window));
        int length = line.length();
        for (int i = 0; i < length; i++) {
            insert(new Character(line.charAt(i)), i);
        }
    }

    /**
     * Creates a column with a row child for every string. Every row contains
     * the children character glyphs for each string. The column and row will
     * be composed with the SimpleCompositor.
     * 
     * @param line   String to create character children from.
     * @param window Window to draw the column.
     */
    public Column(String lines[], Window window) {
        super(new SimpleCompositor(window));
        int length = lines.length;
        for (int i = 0; i < length; i++) {
            insert(new Row(lines[i], window), i);
        }
    }

    @Override
    public void adjust(Glyph child, Bounds cursor) {
        Bounds childBounds = child.getBounds();
        int cursorX = cursor.getX();
        int cursorY = cursor.getY() + childBounds.getHeight();
        cursor.setPoint(cursorX, cursorY);
        int cursorWidth = Math.max(cursor.getWidth(), childBounds.getWidth());
        int cursorHeight = cursor.getHeight() + childBounds.getHeight();
        cursor.setSize(cursorWidth, cursorHeight);
        bounds.setSize(cursorWidth, cursorHeight);
    }

}

// Composite(163): Composite
// Decorator(175): ConcreteDecorator

package glyph.composition.embellishment;

import glyph.Glyph;
import glyph.compositor.Compositor;
import util.Bounds;
import window.Window;
/**
 * This class implements a border embellishment.
 * 
 * @author Digno JR Teogalbo
 * @version CS472 Sp24
 */
public class Border extends Embellishment {

    private int width;

    /**
     * Creates a border embellishment with the provided width of the border
     * in pixels. Uses the SimpleCompositor to compose the contents of the
     * border and itself.
     * 
     * @param width  Width of the border.
     * @param window Window for the SimpleCompositor.
     */
    public Border(int width, Window window) {
        super(window);
        this.width = width;
    }

    /**
     * Creates a border embellishment with the provided width of the border
     * in pixels. Uses the provided compositors to compose itself and its
     * contents.
     * 
     * @param width         Width of the border.
     * @param embellishment Compositor for the border.
     * @param contents      Compositor for the border contents.
     */
    public Border(int width, Compositor embellishment) {
        super(embellishment);
        this.width = width;
    }

    @Override
    public Bounds createCursor() {
        int x = bounds.getX();
        int y = bounds.getY();
        return new Bounds(x + width, y + width, 0, 0);
    }

    @Override
    public void adjust(Glyph child, Bounds cursor) {
        int thickness = 2 * width;
        Bounds childBounds = child.getBounds();
        cursor.setSize(childBounds.getWidth() + thickness, childBounds.getHeight() + thickness);
        bounds.setSize(cursor.getWidth(), cursor.getHeight());
    }

    @Override
    protected void drawEmbellishment(Window window) {
        int x1 = bounds.getX();
        int y1 = bounds.getY();
        int x2 = x1 + bounds.getWidth();
        int y2 = y1 + bounds.getHeight();
        window.addBorder(x1, y1, x2, y2, width);
    }
}

// Composite(163): Composite
// Decorator(175): ConcreteDecorator

package glyph.composition.embellishment;

import glyph.Glyph;
import glyph.compositor.Compositor;
import util.Bounds;
import window.Window;
/**
 * This class implements a scroller embellishment.
 * 
 * @author Digno JR Teogalbo
 * @version CS472 Sp24
 */
public class Scroller extends Embellishment {

    private int width;

    /**
     * Creates a scroller embellishment with the provided width of the scroller
     * in pixels. Uses the SimpleCompositor to compose the contents of the
     * scroller and itself.
     * 
     * @param width  Width of the scroller.
     * @param window Window for the SimpleCompositor.
     */
    public Scroller(int width, Window window) {
        super(window);
        this.width = width;
    }

    /**
     * Creates a scroller embellishment with the provided width of the scroller
     * in pixels. Uses the provided compositors to compose itself and its
     * contents.
     * 
     * @param width         Width of the scroller.
     * @param embellishment Compositor for the scroller.
     * @param contents      Compositor for the scroller contents.
     */
    public Scroller(int width, Compositor embellishment) {
        super(embellishment);
        this.width = width;
    }

    @Override
    public void adjust(Glyph child, Bounds cursor) {
        Bounds childBounds = child.getBounds();
        cursor.setSize(childBounds.getWidth() + width, childBounds.getHeight());
        bounds.setSize(cursor.getWidth(), cursor.getHeight());
    }

    @Override
    protected void drawEmbellishment(Window window) {
        int x = bounds.getX() + bounds.getWidth() - width;
        int y = bounds.getY();
        int height = bounds.getHeight();
        window.addScrollBar(x, y, width, height);
    }
}

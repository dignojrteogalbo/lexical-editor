// Composite(163): Composite
// Decorator(175): Decorator

package glyph.composition.embellishment;

import glyph.composition.Composition;
import glyph.compositor.Compositor;
import glyph.compositor.SimpleCompositor;
import window.Window;
/**
 * This abstract represents an embellishment with a composition.
 * 
 * @author Digno JR Teogalbo
 * @version CS472 Sp24
 */
public abstract class Embellishment extends Composition {

    /**
     * Creates an embellisment using SimpleCompositor to compose the
     * embellishment and its contents.
     * 
     * @param window Window for the SimpleCompositor.
     */
    public Embellishment(Window window) {
        super(new SimpleCompositor(window));
    }

    /**
     * Creates an embellishment using the provided compositors for the
     * embellishment and its contents.
     * 
     * @param embellishment Compositor for the embellishment.
     */
    public Embellishment(Compositor embellishment) {
        super(embellishment);
    }

    protected abstract void drawEmbellishment(Window window);

    @Override
    public void draw(Window window) {
        drawEmbellishment(window);
        super.draw(window);
    }
}

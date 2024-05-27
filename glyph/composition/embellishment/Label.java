// AbstractFactory(87): AbstractProduct
// FactoryMethod(107): Product

package glyph.composition.embellishment;

import glyph.Glyph;
import glyph.compositor.Compositor;
import util.Bounds;
import window.Window;
public abstract class Label extends Embellishment {

    public Label(Window window) {
        super(window);
    }

    public Label(Compositor contents) {
        super(contents);
    }

    @Override
    public void adjust(Glyph child, Bounds cursor) {
        Bounds childBounds = child.getBounds();
        bounds.setSize(childBounds.getWidth(), childBounds.getHeight());
    }
}

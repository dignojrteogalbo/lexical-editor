// AbstractFactory(87): ConcreteProduct
// FactoryMethod(107): ConcreteProduct

package factory.widget;

import glyph.composition.embellishment.Label;
import glyph.compositor.Compositor;
import window.Window;
class GreenLabel extends Label {

    public GreenLabel(Window window) {
        super(window);
    }

    public GreenLabel(Compositor embellishment) {
        super(embellishment);
    }

    @Override
    protected void drawEmbellishment(Window window) {
        int x = bounds.getX();
        int y = bounds.getY();
        int width = bounds.getWidth();
        int height = bounds.getHeight();
        window.drawLabel(x, y, width, height, GreenFactory.color);
    }
}

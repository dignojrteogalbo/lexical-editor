// AbstractFactory(87): ConcreteProduct
// FactoryMethod(107): ConcreteProduct

package factory.widget;

import command.Command;
import glyph.composition.embellishment.Button;
import glyph.compositor.Compositor;
import window.Window;

class GreenButton extends Button {

    public GreenButton(Window window, Command command) {
        super(window, command);
    }

    public GreenButton(Window window) {
        super(window);
    }

    public GreenButton(Compositor embellishment) {
        super(embellishment);
    }

    @Override
    protected void drawEmbellishment(Window window) {
        int x = bounds.getX();
        int y = bounds.getY();
        int width = bounds.getWidth();
        int height = bounds.getHeight();
        window.drawButton(x, y, width, height, GreenFactory.color);
    }
}

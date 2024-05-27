// AbstractFactory(87): AbstractProduct
// FactoryMethod(107): Product
// ChainOfResponsibility(223): ConcreteHandler

package glyph.composition.embellishment;

import command.Command;
import glyph.Glyph;
import glyph.compositor.Compositor;
import util.Bounds;
import window.Window;

public abstract class Button extends Embellishment {

    private Command command;

    public Button(Window window, Command command) {
        super(window);
        this.command = command;
    }

    public Button(Window window) {
        super(window);
    }

    public Button(Compositor contents) {
        super(contents);
    }

    @Override
    public void adjust(Glyph child, Bounds cursor) {
        Bounds childBounds = child.getBounds();
        bounds.setSize(childBounds.getWidth(), childBounds.getHeight());
    }

    @Override
    public Glyph find(int x, int y) {
        if (!intersects(x, y)) return null;
        return this;
    }

    @Override
    public Command click() {
        return command;
    }
}

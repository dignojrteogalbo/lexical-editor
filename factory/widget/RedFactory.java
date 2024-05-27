// AbstractFactory(87): ConcreteFactory
// FactoryMethod(107): ConcreteCreator

package factory.widget;

import command.Command;
import glyph.composition.embellishment.Button;
import glyph.composition.embellishment.Label;
import window.Window;
class RedFactory extends WidgetFactory {

    public static String color = "red";

    public RedFactory() {
        System.out.println("The factory is: " + color);
    }

    @Override
    protected Button buttonFactoryMethod(Window window, Command command) {
        return new RedButton(window, command);
    }

    @Override
    protected Button buttonFactoryMethod(Window window) {
        return new RedButton(window);
    }

    @Override
    protected Label labelFactoryMethod(Window window) {
        return new RedLabel(window);
    }
}

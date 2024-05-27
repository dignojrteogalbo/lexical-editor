// AbstractFactory(87): ConcreteFactory
// FactoryMethod(107): ConcreteCreator

package factory.widget;

import command.Command;
import glyph.composition.embellishment.Button;
import glyph.composition.embellishment.Label;
import window.Window;
class GreenFactory extends WidgetFactory {

    public static String color = "green";

    public GreenFactory() {
        System.out.println("The factory is: " + color);
    }

    @Override
    protected Button buttonFactoryMethod(Window window, Command command) {
        return new GreenButton(window, command);
    }

    @Override
    protected Button buttonFactoryMethod(Window window) {
        return new GreenButton(window);
    }

    @Override
    protected Label labelFactoryMethod(Window window) {
        return new GreenLabel(window);
    }

}

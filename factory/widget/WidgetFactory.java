// Singleton(127): Singleton
// AbstractFactory(87): AbstractFactory
// FactoryMethod(107): Creator

package factory.widget;

import command.Command;
import glyph.composition.embellishment.Button;
import glyph.composition.embellishment.Label;
import window.Window;
public abstract class WidgetFactory {

    private static String lookAndFeel = "LookAndFeel";
    private static WidgetFactory instance;

    protected WidgetFactory() {}

    private static WidgetFactory selectFactory(String name) {
        if (name.equalsIgnoreCase(GreenFactory.color))
            return new GreenFactory();
        if (name.equalsIgnoreCase(RedFactory.color))
            return new RedFactory();
        return new GreenFactory(); // default
    }

    /**
     * Returns the unique instance of the GUIFactory.
     * 
     * @return Instance of the GUIFactory.
     */
    public static final WidgetFactory getInstance() {
        if (instance == null) {
            String lookAndFeel = System.getenv(WidgetFactory.lookAndFeel);
            if (lookAndFeel != null) {
                instance = selectFactory(lookAndFeel);
            } else {
                instance = new GreenFactory();
            }
        }
        return instance;
    }

    /**
     * Returns a button created by the GUIFactory.
     * 
     * @param window Window for the button.
     * @return Button embellishment.
     */
    public final Button createButton(Window window, Command command) {
        return getInstance().buttonFactoryMethod(window, command);
    }

    /**
     * Returns a button created by the GUIFactory.
     * 
     * @param window Window for the button.
     * @return Button embellishment.
     */
    public final Button createButton(Window window) {
        return getInstance().buttonFactoryMethod(window);
    }

    /**
     * Returns a lebel created by the GUIFactory.
     * 
     * @param window Window for the label.
     * @return Label embellishment.
     */
    public final Label createLabel(Window window) {
        return getInstance().labelFactoryMethod(window);
    }

    /**
     * Factory method to create a button.
     * 
     * @param window Window for the button
     * @return Button embellishment.
     */
    protected abstract Button buttonFactoryMethod(Window window, Command command);

    /**
     * Factory method to create a button.
     * 
     * @param window Window for the button
     * @return Button embellishment.
     */
    protected abstract Button buttonFactoryMethod(Window window);

    /**
     * Factory method to create a label.
     * 
     * @param window Window for the label
     * @return Button embellishment.
     */
    protected abstract Label labelFactoryMethod(Window window);
}

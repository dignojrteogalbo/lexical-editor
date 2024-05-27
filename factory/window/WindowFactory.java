// Singleton(127): Singleton
// AbstractFactory(87): AbstractFactory
// FactoryMethod(107): Creator

package factory.window;

import window.Window;

public abstract class WindowFactory {

    private static String toolkit = "WindowToolkit";
    private static WindowFactory instance;

    protected WindowFactory() {
    }

    private static WindowFactory selectFactory(String name) {
        if (name.equalsIgnoreCase(SwingFactory.name))
            return new SwingFactory();
        if (name.equalsIgnoreCase(AwtFactory.name))
            return new AwtFactory();
        return new SwingFactory(); // default
    }

    /**
     * Returns the unique instance of the GUIFactory.
     * 
     * @return Instance of the GUIFactory.
     */
    public static final WindowFactory getInstance() {
        if (instance == null) {
            String toolkit = System.getenv(WindowFactory.toolkit);
            if (toolkit != null) {
                instance = selectFactory(toolkit);
            } else {
                instance = new SwingFactory();
            }
        }
        return instance;
    }

    /**
     * Returns a window created by the WindowFactory.
     * 
     * @return Window.
     */
    public final WindowImp createWindowImp(String title, Window window) {
        return getInstance().windowFactoryMethod(title, window);
    }

    /**
     * Factory method to create a button.
     * 
     * @param window Window for the button
     * @return Button embellishment.
     */
    protected abstract WindowImp windowFactoryMethod(String title, Window window);
}

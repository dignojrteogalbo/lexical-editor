// AbstractFactory(87): ConcreteFactory
// FactoryMethod(107): ConcreteCreator

package factory.window;

import window.Window;

class SwingFactory extends WindowFactory {

    public static String name = "swing";

    public SwingFactory() {
        System.out.println("The window factory is: " + name);
    }

    @Override
    protected WindowImp windowFactoryMethod(String title, Window window) {
        return new SwingWindow(title, window);
    }

}

// AbstractFactory(87): ConcreteFactory
// FactoryMethod(107): ConcreteCreator

package factory.window;

import window.Window;

class AwtFactory extends WindowFactory {

    public static String name = "awt";

    public AwtFactory() {
        System.out.println("The window factory is: " + name);
    }

    @Override
    protected WindowImp windowFactoryMethod(String title, Window window) {
        return new AwtWindow(title, window);
    }

}

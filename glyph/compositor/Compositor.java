// Strategy(315): Strategy

package glyph.compositor;

import glyph.composition.Composition;
import window.Window;
/**
 * This abstract class represents a compositor strategy.
 * 
 * @author Digno JR Teogalbo
 * @version CS472 Sp24
 */
public abstract class Compositor {

    protected Window window;
    protected Composition composition;

    /**
     * Initializes the compositor strategy with the provided window as context.
     * 
     * @param window Window for the compositor.
     */
    public Compositor(Window window) {
        this.window = window;
    }

    /**
     * Sets the compositon for the compositor.
     * 
     * @param composition Composition to compose.
     */
    public final void setComposition(Composition composition) {
        this.composition = composition;
    }
    
    /**
     * Returns the window of the compositor.
     * 
     * @return Window of the compositor.
     */
    public final Window getWindow() {
        return window;
    }

    /**
     * Performs the compositor strategy upon the composition.
     */
    public abstract void compose();

}

// Composite(163): Composite
// Strategy(315): Context
// Decorator(175): Component

package glyph.composition;

import glyph.CompositeGlyph;
import glyph.Glyph;
import glyph.compositor.Compositor;
import iterator.Iterator;
import util.Bounds;
import window.Window;
/**
 * This abstract represents a composition with a compositor.
 * 
 * @author Digno JR Teogalbo
 * @version CS472 Sp24
 */
public abstract class Composition extends CompositeGlyph {

    private Compositor compositor;

    /**
     * Initializes a composition from the provided compositor.
     * 
     * @param compositor Compositor of the composition.
     */
    public Composition(Compositor compositor) {
        setCompositor(compositor);
    }

    /**
     * Returns the compositor of the composition.
     * 
     * @return Compositor of this composition.
     */
    public final Compositor getCompositor() {
        return compositor;
    }

    /**
     * Sets the compositor strategy of the composition.
     * 
     * @param compositor New compositor of the composition.
     */
    public final void setCompositor(Compositor compositor) {
        this.compositor = compositor;
    }

    @Override
    public void compose() {
        compositor.setComposition(this);
        compositor.compose();
    }

    @Override
    public Bounds createCursor() {
        return new Bounds(bounds.getX(), bounds.getY(), 0, 0);
    }

    @Override
    public void draw(Window window) {
        Iterator<Glyph> iter = createIterator();
        for (iter.first(); iter.hasNext(); iter.next())
            iter.current().draw(window);
    }

    @Override
    public void setSize(Window window) {
        // Do nothing. Size will be set from composing children.
    }

    @Override
    public void insert(Glyph glyph, int position) throws IndexOutOfBoundsException {
        super.insert(glyph, position);
        getRoot().compose();
    }

    @Override
    public void insert(Glyph glyph) {
        super.insert(glyph);
        getRoot().compose();
    }

    @Override
    public void remove(Glyph glyph) {
        super.remove(glyph);
        getRoot().compose();
    }

}

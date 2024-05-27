// Composite(163): Component
// ChainOfResponsibility(223): Handler
// Iterator(257): Aggregate, ConcreteAggregate (NullIterator)
// Visitor(331): Element, ObjectStructure
// FactoryMethod(107): ConcreteCreator

package glyph;

import command.Command;
import exceptions.NoChildException;
import util.Bounds;
import visitor.GlyphVisitor;
import window.Window;
import iterator.Iterable;
import iterator.Iterator;
import iterator.NullIterator;

/**
 * This interface represents the operations of a Glyph.
 * 
 * @author Digno JR Teogalbo
 * @version CS472 Sp24
 */
public abstract class Glyph implements Iterable<Glyph> {

    private static String NO_CHILD_MESSAGE = "Glyph cannot hold children.";

    protected Bounds bounds = new Bounds(0, 0, 0, 0);
    protected CompositeGlyph parent;

    /**
     * Goes up the tree hierarchy by parent to return the root glyph.
     * 
     * @return Root glyph of the glyph hierarchy
     */
    public Glyph getRoot() {
        if (parent == null)
            return this;
        return parent.getRoot();
    }

    /**
     * Draws the glyph on the window.
     * 
     * @param window The window of a glyph.
     */
    public abstract void draw(Window window);

    /**
     * Returns the bounds of a glyph.
     * 
     * @return Bounds of a glpyh.
     */
    public Bounds getBounds() {
        return bounds;
    }

    /**
     * Sets the bounds of a glyph to a new bounds.
     * 
     * @param bounds The new bounds to set.
     */
    public void setBounds(Bounds bounds) {
        this.bounds = bounds;
    }

    /**
     * Sets the width and height of a glyph based on the window.
     * 
     * @param window The window of the glyph
     */
    public abstract void setSize(Window window);

    /**
     * Checks if the provided x and y point intersects with the
     * bounds of the glyph.
     * 
     * @param x The x coordinate
     * @param y The y coordinate
     * @return True if the x and y intersects the glyph bounds, otherwise false.
     */
    public boolean intersects(int x, int y) {
        return bounds.intersects(x, y);
    }

    /**
     * Inserts the glyph into the children of the glyph. Existing children will
     * be shifted by +1 index.
     * 
     * @param glyph    Glyph to insert
     * @param position Position of the child to insert
     * @throws NoChildException          If invoked on a glyph that cannot hold
     *                                   children
     * @throws IndexOutOfBoundsException If the position provided is out of bounds.
     */
    public void insert(Glyph glyph, int position) throws NoChildException, IndexOutOfBoundsException {
        throw new NoChildException(NO_CHILD_MESSAGE);
    }

    public void insert(Glyph glyph) throws NoChildException {
        throw new NoChildException(NO_CHILD_MESSAGE);
    }

    /**
     * Removes the glyph as a child.
     * 
     * @param glyph Glyph to remove.
     * @throws NoChildException If invoked on a glyph that cannot hold children.
     */
    public void remove(Glyph glyph) throws NoChildException {
        throw new NoChildException(NO_CHILD_MESSAGE);
    }

    /**
     * Retrieves the parent glyph.
     * 
     * @return Parent glyph.
     */
    public CompositeGlyph getParent() {
        return parent;
    }

    /**
     * Sets the parent glyph to the provided glyph.
     * 
     * @param parent New parent glyph.
     */
    public void setParent(CompositeGlyph parent) {
        this.parent = parent;
    }

    /**
     * Composes the glyph.
     */
    public void compose() {
        // Most glyphs are not composable. Do nothing.
    }

    /**
     * Creates the cursor for the compositor to begin composing.
     * 
     * @return Cursor created by the glyph.
     */
    public Bounds createCursor() {
        throw new UnsupportedOperationException("Glyph does not support createCursor().");
    }

    /**
     * Adjusts the glyph based on the child and cursor.
     * 
     * @param child  Composed child.
     * @param cursor Compositor cursor.
     */
    public void adjust(Glyph child, Bounds cursor) {
        throw new UnsupportedOperationException("Glyph does not support adjust().");
    }

    public Glyph find(int x, int y) {
        if (!intersects(x, y)) return null;
        return this;
    }

    public Command click() {
        // Most glyphs don't do anything when clicked. Do nothing.
        return null;
    }

    @Override
    public Iterator<Glyph> createIterator() {
        return new NullIterator<>();
    }

    public void accept(GlyphVisitor visitor) {
        visitor.visit(this);
    }
}

// Composite(163): Composite
// Iterator(257): ConcreteAggregate
// Visitor(331): ObjectStructure
// FactoryMethod(107): ConcreteCreator

package glyph;

import java.util.ArrayList;
import java.util.List;

import iterator.Iterator;
import iterator.ListIterator;

/**
 * This interface represents the operations of a CompositeGlyph.
 * 
 * @author Digno JR Teogalbo
 * @version CS472 Sp24
 */
public abstract class CompositeGlyph extends Glyph {

    private List<Glyph> children = new ArrayList<>();

    @Override
    public Iterator<Glyph> createIterator() {
        return new ListIterator<>(children);
    }

    @Override
    public void insert(Glyph glyph, int position) throws IndexOutOfBoundsException {
        children.add(position, glyph);
        glyph.setParent(this);
    }

    @Override
    public void insert(Glyph glyph) {
        children.add(glyph);
        glyph.setParent(this);
    }

    @Override
    public void remove(Glyph glyph) {
        children.remove(glyph);
        glyph.setParent(null);
    }

    @Override
    public Glyph find(int x, int y) {
        if (!intersects(x, y)) return null;
        Iterator<Glyph> iter = createIterator();
        for (iter.first(); iter.hasNext(); iter.next()) {
            Glyph glyph = iter.current().find(x, y);
            if (glyph != null) return glyph;
        }
        return null;
    }
}

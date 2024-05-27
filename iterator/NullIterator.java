// Iterator(257): ConcreteIterator
// FactoryMethod(107): Product

package iterator;

public class NullIterator<E> implements Iterator<E> {

    public NullIterator() {}

    public void first() {}

    public boolean hasNext() { return false; }

    public E current() { return null; }

    public void next() {}
}
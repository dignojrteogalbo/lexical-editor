// Iterator(257): Iterator
// FactoryMethod(107): Product

package iterator;

public interface Iterator<E> {
    void first();
    boolean hasNext();
    E current();
    void next();
}
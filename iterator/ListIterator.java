// Iterator(257): ConcreteIterator
// FactoryMethod(107): Product

package iterator;

import java.util.List;

public class ListIterator<E> implements Iterator<E> {

    private List<E> list;
    private int index = 0;
    private E current = null;

    public ListIterator(List<E> list) {
        this.list = list;
    }

    private void setCurrent(int index) {
        try {
            current = list.get(index);
        } catch (IndexOutOfBoundsException e) {
            current = null;
        }
    }

    public void first() {
        index = 0;
        setCurrent(index);
    }

    public boolean hasNext() {
        return index >= 0 && index < list.size();
    }

    public E current() {
        return current;
    }

    public void next() {
        setCurrent(++index);
    }
}
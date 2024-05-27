// Iterator(257): ConcreteIterator
// FactoryMethod(107): Product

package iterator;

import java.util.Deque;
import java.util.LinkedList;

public class PreorderIterator<E extends Iterable<E>> implements Iterator<E> {

    private Iterable<E> iterable;
    private Deque<Iterator<E>> stack = new LinkedList<>();

    public PreorderIterator(Iterable<E> iterable) {
        this.iterable = iterable;
    }

    @Override
    public void first() {
        Iterator<E> root = iterable.createIterator();
        root.first();
        stack.clear();
        if (!root.hasNext()) return;
        stack.addFirst(root);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public E current() {
        return !stack.isEmpty() ? top().current() : null;
    }

    private Iterator<E> top() {
        return stack.peekFirst();
    }

    @Override
    public void next() {
        Iterator<E> iterator = top().current().createIterator();
        iterator.first();
        stack.addFirst(iterator);
        while (!stack.isEmpty() && !top().hasNext()) {
            stack.removeFirst();
            if (!stack.isEmpty() && top().hasNext())
                top().next();
        }
    }

}

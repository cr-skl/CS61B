/**
 * Deque creates an INTERFACE that can function as other CLASS
 * that's declared with its INTERFACE NAME   eg:  class XXX implements Deque(INTERFACE name)  {...}
 * @param <T>
 */
public interface Deque<T> {
    void addFirst(T item);
    void addLast(T item);
    boolean isEmpty();
    int size();
    void printDeque();
    T removeFirst();
    T removeLast();
    T get(int index);
}

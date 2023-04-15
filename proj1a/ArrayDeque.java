public class ArrayDeque<T> {
    /** num of elements stored in deque*/
    private int size;
    /** length of the deque , or to say , capacity*/
    private int length;
    private T[] array;
    private int first;
    private int last;

    /** Basic methods */
    public ArrayDeque() {
        size = 0;
        length = 8;
        array = (T[]) new Object[8];
        first = 4;
        last = 5;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    /** special method for the deque to be circular */
    private int plusOne(int index, int len) {
        if (index == len - 1) {
            return 0;
        }
        return index + 1;
    }
    private int minusOne(int index, int len) {
        if (index == 0) {
            return len - 1;
        }
        return  index - 1;
    }

    /**
      *  condition judgement for
      *  adjusting capacity of deque
      * @return
      */
    private boolean shouldDouble() {
        if (plusOne(last, length) == first) {
            return true;
        }
        return false;
    }
    private boolean shouldHalf() {
        // maitain if the size is under 8
        if (size / length < 0.25 && length >= 16) {
            return true;
        }
        return false;
    }

    /**
    *  adjustment of Deque capacity
    *  newly found Deque always has index 0 as its first
    */
    private void doubleDeque() {
        T[] temp = (T[]) new Object[2 * length];
        /**
         * ptr1:  first ----> last
         * ptr2:  0     ----> X
         */
        int ptr1 = first;
        int ptr2 = 0;
        while (ptr1 != last) {
            temp[ptr2] = array[ptr1];
            ptr1 = plusOne(ptr1, length);
            ptr2 = plusOne(ptr2, 2 * length);
        }
        array = temp;
        first = 0;
        last = ptr2;
        length *= 2;
    }
    private void halfDeque() {
        T[] temp = (T[]) new Object[length / 2];
        int ptr1 = first;
        int ptr2 = 0;
        while (ptr1 != last) {
            temp[ptr2] = array[ptr1];
            ptr1 = plusOne(ptr1, length);
            ptr2 = plusOne(ptr2, length / 2);
        }
        array = temp;
        first = 0;
        last = ptr2;
        length /= 2;
    }

    public void addFirst(T item) {
        if (shouldDouble()) {
            doubleDeque();
        }
        array[first] = item;
        first = minusOne(first, length);
        size++;
    }
    public void addLast(T item) {
        if (shouldDouble()) {
            doubleDeque();
        }
        array[last] = item;
        last = plusOne(last, length);
        size++;
    }
    public T removeFirst() {
        if (shouldHalf()) {
            halfDeque();
        }
        if (size == 0) {
            return null;
        }

        first = plusOne(first, length);
        T obj = array[first];
        size--;
        return obj;
    }
    public T removeLast() {
        if (shouldHalf()) {
            halfDeque();
        }
        if (size == 0) {
            return null;
        }

        last = minusOne(last, length);
        T obj = array[last];
        size--;
        return obj;
    }
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        // ptr move to the first element
        int ptr = plusOne(first, length);
        for (int i = 0; i < index; i++) {
            ptr = plusOne(ptr, length);
        }
        return array[ptr];
    }

    /**
     * print elems from first +1 to last -1
     */
    public void printDeque() {
        int ptr = plusOne(first, length);
        while (ptr != minusOne(last, length)) {
            StdOut.print(array[ptr] + " ");
            ptr = plusOne(ptr, length);
        }
    }

}
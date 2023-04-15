public class LinkedListDeque<T> {
    private class Dnode {
        T item;
        Dnode next;
        Dnode pre;

        public Dnode(T item, Dnode next, Dnode pre) {
            this.item = item;
            this.next = next;
            this.pre  = pre;
        }
    }
    private int size;
    private Dnode fakeHead;
    private Dnode fakeTail;


    public LinkedListDeque() {
        size = 0;
        // 初始化节点需要注意先初始化，  再赋值
        // what is in fakeHead or fakeTail is meaningless
        fakeHead = new Dnode(null,  null, null);
        fakeTail = new Dnode(null, null, null);
        fakeHead.next = fakeTail;
        fakeTail.pre = fakeHead;
    }
//    public LinkedListDeque(LinkedListDeque d1) {
//        size = 0;
//        // what is in fakeHead or fakeTail is meaningless
//        fakeHead = new Dnode(null,  null, null);
//        fakeTail = new Dnode(null, null, null);
//        fakeHead.next = fakeTail;
//        fakeTail.pre = fakeHead;
//
//        Dnode p = d1.fakeHead.next;
//        while (p.item != null) {
//            addFirst(p.item);
//        }
//    }
    public void addFirst(T item) {
        Dnode p = new Dnode(item, fakeHead.next, fakeHead);
        fakeHead.next.pre = p;
        fakeHead.next = p;
        size++;
    }
    public void addLast(T item) {
        Dnode p = new Dnode(item, fakeTail, fakeTail.pre);
        fakeTail.pre.next = p;
        fakeTail.pre = p;
        size++;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        Dnode p = fakeHead.next;
        while (p.item != null) {
            StdOut.print(p.item + " ");
            p = p.next;
        }
        StdOut.println();
    }
    public T removeFirst() {
        if (isEmpty())
            return null;
        size--;
        Dnode p = fakeHead.next;
        p.next.pre = fakeHead;
        fakeHead.next = p.next;
        return p.item;
    }
    public T removeLast() {
        if (isEmpty())
            return null;
        size--;
        Dnode p = fakeTail.pre;
        p.pre.next = fakeTail;
        fakeTail.pre = p.pre;
        return p.item;
    }
    public T get(int index) {
        if (index > size - 1 || index < 0) {
            return null;
        }
        Dnode p = fakeHead.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }
    private Dnode getRecursiveHelper(Dnode p, int index) {
        if (index == 0) {
            return p;
        }
        return getRecursiveHelper(p.next, index - 1);
    }

    public T getRecursive(int index) {
        if (index > size - 1 || index < 0) {
            return null;
        }
        return getRecursiveHelper(fakeHead.next, index).item;
    }

}

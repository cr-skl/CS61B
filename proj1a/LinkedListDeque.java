public class LinkedListDeque<T> {
    public class Dnode {
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
    private Dnode fake_head;
    private Dnode fake_tail;


    public LinkedListDeque() {
        size = 0;
        // 初始化节点需要注意先初始化，  再赋值
        // what is in fake_head or fake_tail is meaningless
        fake_head = new Dnode(null,  null, null);
        fake_tail = new Dnode(null, null, null);
        fake_head.next = fake_tail;
        fake_tail.pre = fake_head;
    }
    public LinkedListDeque(LinkedListDeque d1) {
        size = 0;
        // what is in fake_head or fake_tail is meaningless
        fake_head = new Dnode(null,  null, null);
        fake_tail = new Dnode(null, null, null);
        fake_head.next = fake_tail;
        fake_tail.pre = fake_head;

        Dnode p = d1.fake_head.next;
        while (p.item != null) {
            addFirst(p.item);
        }
    }

    public void addFirst(T item) {
        Dnode p = new Dnode(item, fake_head.next, fake_head);
        fake_head.next.pre = p;
        fake_head.next = p;
        size++;
    }
    public void addLast(T item) {
        Dnode p = new Dnode(item, fake_tail, fake_tail.pre);
        fake_tail.pre.next = p;
        fake_tail.pre = p;
        size++;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        Dnode p = fake_head.next;
        while (p.item != null) {
            StdOut.print(p.item + " ");
            p = p.next;
        }
        StdOut.println();
    }
    public T removeFirst() {
        size--;
        Dnode p = fake_head.next;
        p.next.pre = fake_head;
        fake_head.next = p.next;
        return p.item;
    }
    public T removeLast() {
        size--;
        Dnode p = fake_tail.pre;
        p.pre.next = fake_tail;
        fake_tail.pre = p.pre;
        return p.item;
    }
    public T get(int index) {
        if (index > size - 1 || index < 0) {
            return null;
        }
        Dnode p = fake_head.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }
    private Dnode get_recursive(Dnode p, int index) {
        if (index == 0)
            return  p;
        return get_recursive(p.next, index - 1);
    }

    public T getRecursive(int index) {
        if (index > size - 1 || index < 0) {
            return null;
        }
        return get_recursive(fake_head.next, index).item;
    }

}

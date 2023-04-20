import edu.princeton.cs.algs4.StdOut;

import java.util.Formatter;

/**
 * A naked recursive list of integers, similar to what we saw in lecture 3, but
 * with a large number of additional methods.
 *
 * @author P. N. Hilfinger, with some modifications by Josh Hug and melaniecebula
 *         [Do not modify this file.]
 */
public class IntList {
    public int first;
    public IntList rest;

    /**
     * A List with first FIRST0 and rest REST0. add to head
     */
    public IntList(int first0, IntList rest0) {
        first = first0;
        rest = rest0;
    }

    /**
     * A List with null rest, and first = 0.
     */
    public IntList() {
    /* NOTE: public IntList () { }  would also work. */
        this(0, null);
    }

    /**
     * Returns a list equal to L with all elements squared. Destructive.
     */
    public static void dSquareList(IntList L) {

        while (L != null) {
            L.first = L.first * L.first;
            L = L.rest;
        }
    }

    /**
     * Returns a list equal to L with all elements squared. Non-destructive.
     */
    public static IntList squareListIterative(IntList L) {
        if (L == null) {
            return null;
        }
        IntList res = new IntList(L.first * L.first, null);
        IntList ptr = res;
        L = L.rest;
        while (L != null) {
            ptr.rest = new IntList(L.first * L.first, null);
            L = L.rest;
            ptr = ptr.rest;
        }
        return res;
    }

    /**
     * Returns a list equal to L with all elements squared. Non-destructive.
     */
    public static IntList squareListRecursive(IntList L) {
        if (L == null) {
            return null;
        }
        return new IntList(L.first * L.first, squareListRecursive(L.rest));
    }

    /** DO NOT MODIFY ANYTHING ABOVE THIS LINE! */


    /**
     * Returns a list consisting of the elements of A followed by the
     * *  elements of B.  May modify items of A. Don't use 'new'.
     */

    public static IntList dcatenate(IntList A, IntList B) {
        //TODO:  fill in method
        // 1, move to the tail of A
        IntList ptr0 = A;
        while(ptr0.rest != null) {
            ptr0 = ptr0.rest;
        }
        // 2, connect A with B
        ptr0.rest = B;
        return A;
    }

    /**
     * Returns a list consisting of the elements of A followed by the
     * * elements of B.  May NOT modify items of A.  Use 'new'.
     */
    public static IntList catenate(IntList A, IntList B) {
        //TODO:  fill in method
        IntList ptr = new IntList();
        IntList ptr_origin = ptr;
        // 1, add A to ptr
        IntList ptr1 = A;
        while(ptr1 != null) {
            IntList temp = new IntList(ptr1.first,null);
            ptr.rest = temp;              // 不能写 ptr = temp 哦
            ptr = ptr.rest;
            ptr1 = ptr1.rest;
        }
        // 2, add B to ptr
        IntList ptr2 = B;
        while(ptr2 != null) {
            IntList temp = new IntList(ptr2.first,null);
            ptr.rest = temp;
            ptr = ptr.rest;
            ptr2 = ptr2.rest;
        }
        return ptr_origin.rest;
    }

    /**
     * Returns the reverse of the given IntList.
     * This method is destructive. If given null
     * as an input, returns null.
     */
    public static IntList reverse(IntList A) {
        IntList p0 = null;
        IntList p1 = A;
        IntList temp = null;
        while (p1 != null) {
            temp = p1.rest;
            p1.rest = p0;
            p0 = p1;
            p1 = temp;
        }
        return p0;
    }















    /**
     * DO NOT MODIFY ANYTHING BELOW THIS LINE! Many of the concepts below here
     * will be introduced later in the course or feature some form of advanced
     * trickery which we implemented to help make your life a little easier for
     * the lab.
     */

    @Override
    public int hashCode() {
        return first;
    }

    /**
     * Returns a new IntList containing the ints in ARGS. You are not
     * expected to read or understand this method.
     */
    public static IntList of(Integer... args) {
        IntList result, p;

        if (args.length > 0) {
            result = new IntList(args[0], null);
        } else {
            return null;
        }

        int k;
        for (k = 1, p = result; k < args.length; k += 1, p = p.rest) {
            p.rest = new IntList(args[k], null);
        }
        return result;
    }

    /**
     * Returns true iff X is an IntList containing the same sequence of ints
     * as THIS. Cannot handle IntLists with cycles. You are not expected to
     * read or understand this method.
     */
    public boolean equals(Object x) {
        if (!(x instanceof IntList)) {
            return false;
        }
        IntList L = (IntList) x;
        IntList p;

        for (p = this; p != null && L != null; p = p.rest, L = L.rest) {
            if (p.first != L.first) {
                return false;
            }
        }
        if (p != null || L != null) {
            return false;
        }
        return true;
    }

    /**
     * If a cycle exists in the IntList, this method
     * returns an integer equal to the item number of the location where the
     * cycle is detected.
     * <p>
     * If there is no cycle, the number 0 is returned instead. This is a
     * utility method for lab2. You are not expected to read, understand, or
     * even use this method. The point of this method is so that if you convert
     * an IntList into a String and that IntList has a loop, your computer
     * doesn't get stuck in an infinite loop.
     */

    private int detectCycles(IntList A) {
        IntList tortoise = A;
        IntList hare = A;

        if (A == null) {
            return 0;
        }

        int cnt = 0;


        while (true) {
            cnt++;
            if (hare.rest != null) {
                hare = hare.rest.rest;
            } else {
                return 0;
            }

            tortoise = tortoise.rest;

            if (tortoise == null || hare == null) {
                return 0;
            }

            if (hare == tortoise) {
                return cnt;
            }
        }
    }

    @Override
    /** Outputs the IntList as a String. You are not expected to read
     * or understand this method. */
    public String toString() {
        Formatter out = new Formatter();
        String sep;
        sep = "(";
        int cycleLocation = detectCycles(this);
        int cnt = 0;

        for (IntList p = this; p != null; p = p.rest) {
            out.format("%s%d", sep, p.first);
            sep = ", ";

            cnt++;
            if ((cnt > cycleLocation) && (cycleLocation > 0)) {
                out.format("... (cycle exists) ...");
                break;
            }
        }
        out.format(")");
        return out.toString();
    }



    public int size() {
        if (this.rest == null)
            return 1;
        else
            return 1 + this.rest.size();
    }


    public int iterativesize() {
        int len = 0;
        IntList p1 = this;
        while (p1 != null) {
            len ++;
            p1 = p1.rest;
        }
        return len;
    }


    public int get(int index){
        if (index == 0)
            return first;
        else
            return rest.get(index -1);
    }

    public int iterativeget(int index) {
        IntList p = this;
        while (index != 0) {
            index --;
            p = p.rest;
        }
        return p.first;
    }

    /** Returns an IntList identical to L, but with
     * each element incremented by x. L is not allowed
     * to change. */
    public static IntList incrList(IntList L, int x) {
        /* Your code here. */
        IntList dummyp = new IntList(-1,null);
        IntList p = dummyp.rest;
        while(L != null) {
            p = new IntList(x+ L.first, null);
            p = p.rest;
            L = L.rest;
        }
        return  dummyp.rest;
    }

    /** Returns an IntList identical to L, but with
     * each element incremented by x. Not allowed to use
     * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        /* Your code here. */
        IntList L1 = L;
        while(L1 != null) {
            L1.first += x;
            L1 = L1.rest;
        }
        return L;
    }

    public static void main(String[] args) {
        IntList L = new IntList(1,null);
        L = new IntList(2, L);
        L = new IntList(3, L);
        StdOut.println(L.size());
        StdOut.println(L.iterativesize());
        StdOut.println(L.get(2));
        StdOut.println(L.iterativeget(2));

        L = IntList.dincrList(L,10);
        StdOut.println(L.get(2));
        IntList L1 = IntList.dincrList(L,20);
        StdOut.println(L1.get(2));
    }
}


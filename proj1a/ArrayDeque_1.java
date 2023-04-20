public class ArrayDeque_1 <T>{
        private int size;
        private T[] array;
        private int nextFirst;
        private int nextLast;
        // to make it circular, nextLast     and nextFirst should both be circular, which will be

        public ArrayDeque_1() {
            nextFirst = 4;
            nextLast = 5;
            array = (T[]) new Object[8];
        }
        private boolean needtobecut() {
            double ratio = size / array.length;
            if(ratio < 0.25)
                return true;
            else
                return false;
        }
        public void resizing(int new_len){
            T[] temp = (T[]) new Object[new_len];
            System.arraycopy(array,0,temp,0, array.length);
            array = temp;
        }
        public void addFirst(T item) {
            // 满了， 需要扩容
            if(size == array.length - 1) {
                resizing( 2 * size);
            }
            // 特殊情况在nextFirst = 0处
            // 在nextFirst处填入元素， nextFirst 往前顺延-1
            array[nextFirst] = item;

            if(nextFirst == 0) {
                nextFirst = array.length - 1;
            }
            else
                nextLast --;

            size++;
        }
        public void addLast(T item) {
            // 满了， 需要扩容
            if(nextLast + 1 == nextFirst) {
                resizing( 2 * size);
            }

            // 特殊情况在nextLast = legnth - 1处
            // 在nextLast处填入元素， nextLast 顺延+1
            array[nextLast] = item;

            if(nextLast == array.length - 1) {
                nextLast = 0;
            }
            else
                nextLast ++;

            size++;
        }
        public boolean isEmpty() {
            return size == 0;
        }
        public int size() {
            return size;
        }
        public void printDeque() {
            // 分情况讨论
            if(nextLast == 0 || nextLast < nextFirst) {
                for(int i = nextFirst + 1; i <= array.length - 1; i++)
                    StdOut.print(array[i] + " ");
                for(int i = 0; i <= nextLast - 1; i++)
                    StdOut.print(array[i] + " ");
            }
            else{  //nextLast > nextFirst
                for(int i = nextFirst + 1; i <= nextLast - 1; i++)
                    StdOut.print(array[i] + " ");
            }
            StdOut.println();
        }
        public T removeFirst() {
            size--;
            T temp;
            // 特殊情况在nextFirst = length - 1处
            if(nextFirst == array.length - 1) {
                temp = array[0];
                array[0] = null;
                nextFirst = 0;

            }
            else {
                temp = array[nextFirst + 1];
                array[nextFirst + 1] = null;
                nextFirst = nextFirst + 1;
            }
            //需要修剪，节约空间
            if(needtobecut()) {
                resizing(array.length / 2);
            }
            return temp;
        }
        public T removeLast() {
            size--;
            T temp;
            // 特殊情况在nextLast = 0处
            if(nextLast == 0) {
                temp = array[array.length - 1];
                array[array.length - 1] = null;
                nextLast = array.length - 1;
            }
            else {
                temp = array[nextFirst + 1];
                array[nextFirst + 1] = null;
                nextLast = nextLast - 1;
            }
            //需要修剪，节约空间
            if(needtobecut()) {
                resizing(array.length / 2);
            }
            return temp;
        }
        public T get(int index) {
            if(index < size){
                if(nextFirst + 1 + index> array.length - 1) {
                    int new_index = nextFirst + 1 + index - array.length;
                    return array[new_index];
                }
            }
            return null;
        }
}

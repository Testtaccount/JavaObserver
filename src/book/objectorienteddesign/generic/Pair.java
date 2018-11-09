package book.objectorienteddesign.generic;

public class Pair<A, B> {
    A first;
    B second;

    public Pair(A a, B b) { // constructor
        first = a;
        second = b;
}

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    ///////////////////////////////////////////////////////////////////////////////////////

    public class Portfolio<T> {
        T[ ] data;
        public Portfolio(int capacity) {
//            data = new T[capacity]; // illegal; compiler error
            data = (T[ ]) new Object[capacity]; // legal, but compiler warning
        }
        public T get(int index) { return data[index]; }
        public void set(int index, T element) { data[index] = element; }
    }

    ////////////////////////////////////////////////////////////////////////////////////////
}

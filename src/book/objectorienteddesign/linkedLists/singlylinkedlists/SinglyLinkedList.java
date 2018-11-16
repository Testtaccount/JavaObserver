package book.objectorienteddesign.linkedLists.singlylinkedlists;

import java.util.LinkedList;

public class SinglyLinkedList<E> {

    //---------------- nested Node class ----------------
    private static class Node<E> {
        private E element; // reference to the element stored at this node
        private Node<E> next; // reference to the subsequent node in the list

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }
    //----------- end of nested Node class -----------

    // instance variables of the SinglyLinkedList
    private Node<E> head = null; // head node of the list (or null if empty)
    private Node<E> tail = null; // last node of the list (or null if empty)
    private int size = 0; // number of nodes in the list

    public SinglyLinkedList() {
    } // constructs an initially empty list

    // access methods
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() { // returns (but does not remove) the first element
        if (isEmpty()) return null;
        return head.getElement();
    }

    public E last() { // returns (but does not remove) the last element
        if (isEmpty()) return null;
        return tail.getElement();
    }

    public E get(int index) {
        checkElementIndex(index);
        return node(index).element;
    }

    // update methods

    // nserts the specified element at the specified position in this list.
    // hifts the element currently at that position (if any) and any
    // ubsequent elements to the right (adds one to their indices).
    public void add(int index, E e) {
        checkPositionIndex(index);
        if (index == 0) {
            Node<E> newest = new Node<>(e, node(index));
            head = newest;
        } else {
            Node<E> pre = node(index - 1);
            Node<E> crt = node(index);
            pre.next = new Node<>(e, crt);
        }

        size++;
    }

    public void addFirst(E e) { // adds element e to the front of the list
        head = new Node<>(e, head); // create and link a new node
        if (size == 0)
            tail = head; // special case: new node becomes tail also
        size++;
    }

    public void addLast(E e) { // adds element e to the end of the list
        Node<E> newest = new Node<>(e, null); // node will eventually be the tail
        if (isEmpty())
            head = newest; // special case: previously empty list
        else
            tail.setNext(newest); // new node after existing tail
        tail = newest; // new node becomes the tail
        size++;
    }

    public E remove(int index) {
        checkElementIndex(index);
        if (isEmpty()) return null; // nothing to remove
        if (index == 0) {
            return removeFirst();
        } else {
            E answer = node(index).getElement();
            Node<E> pre = node(index - 1);
            pre.next = node(index + 1);
            size--;
            return answer;
        }
    }

    public E removeFirst() { // removes and returns the first element
        if (isEmpty()) return null; // nothing to remove
        E answer = head.getElement();
        head = head.getNext(); // will become null if list had only one node
        size--;
        if (size == 0)
            tail = null; // special case as list is now empty
        return answer;
    }

    // Returns the (non-null) Node at the specified element index.
    SinglyLinkedList.Node<E> node(int index) {
        SinglyLinkedList.Node<E> x = head;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    // Tells if the argument is the index of an existing element.
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    // Tells if the argument is the index of a valid position for an iterator or an add operation.
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    // Constructs an IndexOutOfBoundsException detail message.
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }
}

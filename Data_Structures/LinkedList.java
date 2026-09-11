/**
 * @author Tresor Bitangimana
 * @since
 *        LinkedList
 */

public class LinkedList<E extends Comparable<E>> {

    // ---------------- nested Node class ----------------
    private static class Node<E> {
        private E data; // reference to the data stored at this node
        private Node<E> next; // reference to the subsequent node in the list

        public Node(E e, Node<E> n) {
            data = e;
            next = n;
        }

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    // instance variables of the LinkedList
    private Node<E> head = null; // head node of the list (or null if empty)
    private Node<E> tail = null; // last node of the list (or null if empty)
    private int size = 0; // number of nodes in the list

    public LinkedList() {
    } // constructs an initially empty list

    // access methods
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() { // returns (but does not remove) the first data
        if (isEmpty())
            return null;
        return head.getData();
    }

    public E last() { // returns (but does not remove) the last data
        if (isEmpty())
            return null;
        return tail.getData();
    }

    // update methods
    public void addFirst(E e) { // adds data e to the front of the list
        head = new Node<>(e, head); // create and link a new node
        if (size == 0)
            tail = head; // special case: new node becomes tail also
        size++;
    }

    public void addLast(E e) { // adds data e to the end of the list
        Node<E> newest = new Node<>(e, null); // node will eventually be the tail
        if (isEmpty())
            head = newest; // special case: previously empty list
        else
            tail.setNext(newest); // new node after existing tail
        tail = newest; // new node becomes the tail
        size++;
    }

    public E removeFirst() { // removes and returns the first data
        if (isEmpty())
            return null; // nothing to remove
        E answer = head.getData();
        head = head.getNext(); // will become null if list had only one node
        size--;
        if (size == 0)
            tail = null; // special case as list is now empty
        return answer;
    }

    public E removeLast() { // removes and returns the last data
        if (isEmpty())
            return null; // nothing to remove
        E answer = tail.getData();
        if (head == tail) { // check for only one item on the list
            head = null;
            tail = null;
            size = 0;
            return answer;
        }
        Node<E> p = head; // find the next to last item
        Node<E> prev;
        do {
            prev = p;
            p = p.getNext();
        } while (p != tail);
        tail = prev; // make the next to last item the last item
        prev.next = null;
        size--;
        return answer;
    }

    public int indexOf(E e) { // return the position of a value in the list
        if (isEmpty())
            return -1;
        Node<E> p = head;
        for (int i = 0; i < size; i++) {
            if (e.equals(p.getData()))
                return i;
            p = p.getNext();
        }
        return -1;
    }

    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    // Implement the following three methods
    // Then implement the main method to test your solution as described in the
    // assignment
    // You may add private methods, but do not change anything above this

    // compare the current linked list against the parameter
    // the lists are equal if they contain the same data items in the same order
    @Override
    public boolean equals(Object o) {
        return false;
    }

    // return a comma delimited string containing the data items in the linked list
    @Override
    public String toString() {
        return null;
    }

    // sort the linked list using insertion sort and changing only Node references
    public void sort() {

    }

    public static void main(String[] args) {

    }

}

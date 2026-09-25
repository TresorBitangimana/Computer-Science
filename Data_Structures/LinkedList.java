import java.util.Scanner;

/**
 * @author Tresor Bitangimana
 * @since Sep 22 2026
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

        LinkedList<?> other = (LinkedList<?>) o; // assigns the incoming object o to oother assuming the
                                                 // incomeing object is an instance of the LinkedList class
        if (other.size != size) // returns false if the two linkedList do not have the same size
            return false;

        Node<E> p = head; // asslign the current LinkedList head to p
        Node<?> q = other.head; // assigns the incomming LinkedList head to q

        for (int i = 0; i < size; i++) {
            if (p != q) // checks if nodes are not equal, if so returns false.
                return false;
            p.getNext(); // moves on to the next node
            q.getNext();
        }
        return true; // returns true, all nodes are equal
    }

    // return a comma delimited string containing the data items in the linked list
    @Override
    public String toString() {

        String str = ""; // string initialization
        Node<E> p = head;

        if (size == 0) // if the size is 0 return, a null value if returned
            return null;
        else if (size == 1) // if size is 1, there is no need for a loop and the data is returned
            return String.valueOf(head.getData());

        for (int i = 0; i < size; i++) { // loops through the linked linked and combine
                                         // all the data in the link as a single string
            if (p.getNext() != null) {
                // adds the data to the string with a comma if it is not the last node
                str += String.valueOf(p.getData()) + ", ";

            } else {
                // adds the last data in the link without comma
                str += String.valueOf(p.getData());
            }
            p = p.getNext(); // moves on to the next node
        }

        return str; // returns the final string.
    }

    // sort the linked list using insertion sort and changing only Node references
    public void sort() {
        if (size < 2) // if size is less than 2 there is no need to sort
            return;
        // sorted will point to the head of the sorted portion (initially null).
        Node<E> sorted = null;
        // current iterates over the original list; each current node is
        // extracted and inserted into sorted.
        Node<E> current = head;

        while (current != null) { // process each node from the original list
            // Save the next node because current will be relinked.
            Node<E> next = current.getNext();

            // If sorted is empty, or current should be the new head of
            // sorted, insert at front.
            if (sorted == null || current.getData().compareTo(sorted.getData()) < 0) {
                current.setNext(sorted);
                sorted = current;
            } else {
                // Otherwise, find the insertion point: node s such that
                // current should be placed after s.
                Node<E> s = sorted;
                // Advance while the next node in sorted is <= current.
                while (s.getNext() != null && s.getNext().getData().compareTo(current.getData()) <= 0) {
                    s = s.getNext();
                }
                // Insert current after s by adjusting next references.
                current.setNext(s.getNext());
                s.setNext(current);
            }

            // Move to the next node in the original list.
            current = next;
        }

        // After all nodes processed, head becomes the head of the sorted list.
        head = sorted;
        // update tail
        if (head == null) {
            tail = null;
        } else {
            Node<E> t = head;
            while (t.getNext() != null)
                t = t.getNext();
            tail = t;
        }
    }

    public static void main(String[] args) {

        // class tasks
        LinkedList<Integer> numList = new LinkedList<Integer>();

        // creates the scanenr object for Systen.in input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter list size: "); // prompts the user for the size of list n
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) { // iterates n times prompting the user to add an int to the list
            System.out.print("Add an int to the list: ");
            if (n == 0) { // if first item calls add first method
                numList.addFirst(scanner.nextInt());
            } else { // else calls addLast method
                numList.addLast(scanner.nextInt());
            }
        }

        numList.sort(); // sorts the numList
        System.out.println(numList); // prints the list with the toString method

        LinkedList<String> strList = new LinkedList<String>(); // creates a LinkedList that holds strings

        System.out.print("Enter list size: "); // prompts the user for the size of list m
        int m = scanner.nextInt();

        for (int i = 0; i < m; i++) { // iterates m times prompting the user to add a string to the list
            System.out.print("Add a string to the list: ");
            if (m == 0) { // if first item calls add first method
                strList.addFirst(scanner.next());
            } else { // else calls addLast method
                strList.addLast(scanner.next());
            }
        }
        strList.sort(); // sorts the list
        System.out.println(strList); // prints the list

        // test the equals method using the LinkedList containing integers and
        // the LinkedList containing Strings
        System.out.println(numList.equals(strList));

        // creates two equals Linkedlists containing integers
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.addFirst(1);
        list1.addLast(5);
        list1.addLast(2);
        list1.addLast(9);
        LinkedList<Integer> list2 = list1;

        System.out.println(list1.equals(list2)); // tests the equality of the two integer LinkedLists

        scanner.close();

    }

}

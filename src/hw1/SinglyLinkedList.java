package hw1;

/**
 * A class that implements a minimal singly-linked list using generics.
 *
 * @param <E> A generic type that can be specified in the construction of a singly-linked list.
 */
public class SinglyLinkedList<E> {

    /**
     * Inner class for a singly-linked list representing a pointer to data.
     */
    protected class Node {
        private E data; // Generic data being stored.
        private Node next; // Pointer to the next node in the linked list.

        /**
         * Initializes <code>data</code> to the parameterized value and <code>next</code> to <code>null</code>.
         *
         * @param data A generic type of data that is being stored in the node.
         */
        public Node(E data) {
            this.data = data;
            this.next = null;
        }

        /**
         * Accessor method for the stored data.
         *
         * @return The generic data being stored in the node.
         */
        public E getData() {
            return this.data;
        }

        /**
         * Accessor method for the next node.
         *
         * @return A pointer for the next node.
         */
        public Node getNext() {
            return next;
        }

        /**
         * Sets the current data to the one specified in the parameter.
         *
         * @param data The generic data being set.
         */
        public void setData(E data) {
            this.data = data;
        }

        /**
         * Sets the next pointer for this node.
         *
         * @param next The new next pointer being set for this node.
         */
        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head; // The first element of the linked list.

    /**
     * Initializes <code>head</code> to <code>null</code>.
     */
    public SinglyLinkedList() {
        this.head = null;
    }

    /**
     * Accessor method for the head of the linked list.
     *
     * @return The head of the linked list.
     */
    public Node getHead() {
        return this.head;
    }

    /**
     * Mutator method for the head of the linked list.
     *
     * @param head The new head being set.
     */
    public void setHead(Node head) {
        this.head = head;
    }

    /**
     * Inserts an element at the end of the linked list.
     *
     * @param data The generic element being added.
     * @throws NullPointerException
     *      Indicates that <code>data</code> is <code>null</code>.
     */
    public void insert(E data) throws NullPointerException {
        if(data == null) {
            throw new NullPointerException("The element cannot be inserted because it is null.");
        }

        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }

            current.setNext(newNode);
        }
    }
}

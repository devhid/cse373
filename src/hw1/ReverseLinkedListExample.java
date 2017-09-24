package hw1;

/**
 * Driver class intended to test the reversal of linked lists by manipulating pointers.
 */
public class ReverseLinkedListExample {
    private final SinglyLinkedList<Integer> integerList = new SinglyLinkedList<>(); // Instantiates a new SinglyLinkedList of type Integer.

    public static void main(String[] args) {
        ReverseLinkedListExample example = new ReverseLinkedListExample();

        example.init();
        example.printList();
    }

    // Adds numbers 1-10 to the linked list. This insertion takes O(n) time.
    private void init() {
        for(int i = 1; i <= 10; i++) {
            integerList.insert(i);
        }

        reverseLinkedList(integerList);
    }

    // Prints out the linked list.
    private void printList() {
        SinglyLinkedList.Node current = integerList.getHead();
        while(current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    /**
     * Reverses the direction of a singly-linked list in linear time.
     *
     * @param linkedList The singly-linked list given to reverse.
     * @param <T> Generic element type that allows the reversal of any type of linked list.
     */
    public static <T> void reverseLinkedList(SinglyLinkedList<T> linkedList) {
        SinglyLinkedList.Node previous = null; // Keep track of previous element.
        SinglyLinkedList.Node next = null; // Keep track of next element.
        SinglyLinkedList.Node current = linkedList.getHead(); // Keep track of current element.

        while(current != null) { // Stop traversing the linked list after the last element is processed.
            next = current.getNext(); // Get the next pointer.
            current.setNext(previous); // Set the current's next pointer to be the previous pointer (reverse pointer direction).
            previous = current; // Set the previous pointer equal to the current.
            current = next; // Set the current pointer equal to the next pointer.
        }

        linkedList.setHead(previous); // Set the head pointer to point to the last element in the linked list.
    }
}

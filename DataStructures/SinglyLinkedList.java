import java.util.NoSuchElementException;

/**
 * Your implementation of a Singly-Linked List.
 */
public class SinglyLinkedList<T> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the element to the front of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!

        // checking for null data
        if (data == null)
            throw new java.lang.IllegalArgumentException();

        // create a new node
        SinglyLinkedListNode<T> new_node = new SinglyLinkedListNode<T>(data, null);

        // if size = 0
        if (size == 0)
        {
            head = new_node;
            tail = new_node;
        }
        // if size is greater than 0
        else
        {
            new_node.setNext(head);
            head = new_node;
        }
        // increment the size of the linkedlist in either case
        size = size + 1;

    }

    /**
     * Adds the element to the back of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        // checking for null data
        if (data == null)
            throw new java.lang.IllegalArgumentException();

        // if you are adding to an empty list, process is same whether you add to back or add to front
        if(size == 0)
        {

            addToFront(data);
        }
        else {
            // create a new node
            SinglyLinkedListNode<T> new_node = new SinglyLinkedListNode<T>(data, null);

            tail.setNext(new_node);
            tail = new_node;

            // increment the size
            size = size + 1;
        }

    }

    /**
     * Removes and returns the first data of the list.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!

        // cannot remove an element from an empty list
        // throw an exception in that case
        if (size == 0)
            throw new java.util.NoSuchElementException();

        T element = head.getData();
        // edge case
        if (size == 1)
        {
            head = null;
            tail = null;
        }
        else
        {
            // next element to head becomes the head
            head = head.getNext();
        }
        // decrease the size of the list in both cases
        size = size - 1;
        return element;
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        // throw an exception in that case
        if (size == 0)
            throw new java.util.NoSuchElementException();

        T element = tail.getData();
        // edge case
        if (size == 1)
        {
            head = null;
            tail = null;
        }
        else
        {
            // initializing a tracker to get to the element prior to the tail
            SinglyLinkedListNode<T> current = head;
            for (int i=0; i <= size - 3; i ++)
            {
                current = current.getNext();
            }
            // ensuring that this element is the last element & does not point to anything else
            current.setNext(null);
            tail = current;
        }
        // in both cases, reduce the size of the array
        size = size - 1;
        return element;
    }

    /**
     * Returns the head node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the head of the list
     */
    public SinglyLinkedListNode<T> getHead() {
        // DO NOT MODIFY THIS METHOD!
        return head;
    }

    /**
     * Returns the tail node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the tail of the list
     */
    public SinglyLinkedListNode<T> getTail() {
        // DO NOT MODIFY THIS METHOD!
        return tail;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    public static void main(String[] args)
    {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        System.out.println("Size of empty list: " + list.size());

        System.out.println("Adding 2 elements");

        for(int i = 0; i < 5; i++)
            list.addToBack(i);

        System.out.println("Size of list: " + list.size());

        SinglyLinkedListNode<Integer> current = list.head;
        while (current.getNext() != null)
        {
            System.out.println(current.getData());
            current = current.getNext();
        }
        System.out.println(current.getData());
        System.out.println("Tail:" + list.getTail().getData());

        System.out.println("Removing from back");
        for(int i = 0; i < 5; i++)
            System.out.println(list.removeFromBack());

        System.out.println("Size: " + list.size());
        System.out.println("Size: " + list.getTail());

//
//        // working with list 2
//        System.out.println("X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X");
//        System.out.println("Working with LIST 2");
//        System.out.println("X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X");
//        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
//        System.out.println("Size of empty list: " + list2.size());
//        System.out.println("Adding 5 elements");
//
//        for(int i = 0; i < 5; i++)
//            list2.addToBack(i);
//
//        System.out.println("Size of list: " + list2.size());
//
//        current = list2.head;
//        while (current.getNext() != null)
//    {
//        System.out.println(current.getData());
//        current = current.getNext();
//    }
//        System.out.println(current.getData());
//
//        System.out.println("Tail:" + list2.getTail().getData());
    }
}
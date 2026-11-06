package util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class LinkedList<E extends Comparable<E>> implements List<E>, Iterable<E>, Cloneable {

    private Node<E> first;   // Pointer to the first node
    private Node<E> last;    // Pointer to the last node
    private Node<E> current; // Pointer to the current node, used for getNext
    private int size;        // Size of the list, i.e., number of elements

    // Constructors and other methods...

    /**
     * Inserts the specified element at the specified position in this list.
     */
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> newNode = new Node<>(element, null);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
            if (size == 0) {
                last = newNode; // First element added
            }
        } else {
            Node<E> prevNode = first.findNode(index - 1);
            newNode.next = prevNode.next;
            prevNode.next = newNode;
            if (newNode.next == null) {
                last = newNode; // If new node is last
            }
        }
        size++;
    }

    /**
     * Appends all of the elements in the specified collection to the end of this list.
     */
    public boolean addAll(LinkedList<? extends E> c) {
        boolean modified = false;
        for (E element : c) {
            addLast(element);
            modified = true;
        }
        return modified;
    }

    /**
     * Inserts all of the elements in the specified collection into this list at the specified position.
     */
    public boolean addAll(int index, LinkedList<? extends E> c) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        boolean modified = false;
        for (E element : c) {
            add(index++, element);
            modified = true;
        }
        return modified;
    }

    /**
     * Returns true if this list contains the specified element.
     */
    public boolean contains(Object o) {
        Node<E> current = first;
        while (current != null) {
            if (current.element.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Returns true if this list contains all of the elements of the specified collection.
     */
    public boolean containsAll(LinkedList<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Compares the specified object with this list for equality.
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinkedList)) return false;
        LinkedList<?> other = (LinkedList<?>) o;
        if (size != other.size) return false;

        Node<E> currentA = first;
        Node<?> currentB = other.first;
        while (currentA != null) {
            if (!currentA.element.equals(currentB.element)) return false;
            currentA = currentA.next;
            currentB = currentB.next;
        }
        return true;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list.
     */
    public int indexOf(Object o) {
        Node<E> current = first;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(o)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element in this list.
     */
    public int lastIndexOf(Object o) {
        Node<E> current = last;
        for (int i = size - 1; i >= 0; i--) {
            if (current.element.equals(o)) {
                return i;
            }
            current = current.prev; // Assuming you have a `prev` pointer in your Node class
        }
        return -1;
    }

    /**
     * Removes the element at the specified position in this list.
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> current = first;
        if (index == 0) {
            first = current.next;
            if (first == null) last = null; // List becomes empty
        } else {
            Node<E> prevNode = current.findNode(index - 1);
            current = prevNode.next;
            prevNode.next = current.next;
            if (prevNode.next == null) last = prevNode; // If last element is removed
        }
        size--;
        return current.element;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     */
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    /**
     * Removes from this list all of its elements that are contained in the specified collection.
     */
    public boolean removeAll(LinkedList<?> c) {
        boolean modified = false;
        for (Object element : c) {
            while (remove(element)) {
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Retains only the elements in this list that are contained in the specified collection.
     */
    public boolean retainAll(LinkedList<?> c) {
        boolean modified = false;
        Node<E> current = first;
        while (current != null) {
            if (!c.contains(current.element)) {
                remove(current.element);
                modified = true;
            }
            current = current.next;
        }
        return modified;
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     */
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> current = first.findNode(index);
        E oldElement = current.element;
        current.element = element;
        return oldElement;
    }

    /**
     * Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.
     */
    public LinkedList<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }
        LinkedList<E> sublist = new LinkedList<>();
        Node<E> current = first.findNode(fromIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            sublist.addLast(current.element); // Assuming addLast method exists
            current = current.next;
        }
        return sublist;
    }

    /**
     * Inserts the specified element at the beginning of this list.
     */
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e, first);
        first = newNode;
        if (size == 0) {
            last = newNode; // First element added
        }
        size++;
    }

    /**
     * Appends the specified element to the end of this list.
     */
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e, null);
        if (last != null) {
            last.next = newNode;
        } else {
            first = newNode; // List was empty
        }
        last = newNode;
        size++;
    }

    /**
     * Removes and returns the first element from this list.
     */
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        E data = first.element;
        first = first.next;
        size--;
        if (isEmpty()) {
            last = null; // List is now empty
        }
        return data;
    }

    /**
     * Removes the first occurrence of the specified element in this list.
     */
    public boolean removeFirstOccurrence(Object o) {
        Node<E> current = first;
        while (current != null) {
            if (current.element.equals(o)) {
                remove(current.element);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Removes and returns the last element from this list.
     */
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        E data = last.element;
        if (size == 1) {
            first = last = null; // List becomes empty
        } else {
            Node<E> secondLast = first.findNode(size - 2);
            secondLast.next = null;
            last = secondLast; // Update last to second last
        }
        size--;
        return data;
    }

    /**
     * Removes the last occurrence of the specified element in this list.
     */
    public boolean removeLastOccurrence(Object o) {
        int lastIndex = lastIndexOf(o);
        if (lastIndex >= 0) {
            remove(lastIndex);
            return true;
        }
        return false;
    }

    /**
     * Removes from this list all of the elements whose index is between fromIndex, inclusive, and toIndex, exclusive.
     */
    public void removeRange(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex >= toIndex) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = fromIndex; i < toIndex; i++) {
            remove(fromIndex); // Always remove from the start of the range
        }
    }

    // Inner Node class...

    private static class Node<E> {
        private E element; // Element data
        private Node<E> next; // Reference to the next node

        Node(E data, Node<E> next) { // Node constructor
            this.element = data;
            this.next = next;
        }

        public Node<E> findNode(int k) {
            Node<E> e = this;
            for (int i = 0; i < k; i++) {
                e = e.next;
            }
            return e;
        }
    } // End of Node class
}

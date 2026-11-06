package utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
Realizuokite visus interfeiso metodus susietojo sarašo pagrindu.
Nesinaudokite java klase LinkedList<E>, visa logika meginkite parasyti patys.
Jeigu reikia, galima kurti papildomus metodus ir kintamuosius.
*/
public class LinkedList<T> implements List<T> {
    public Node<T> head;
    public LinkedList() {
        this.head = null;
    }

    @Override
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if(head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.SetNext(newNode);
        }
    }

    @Override
    public T get(int index) {
        Node<T> current = head;
        int count = 0;

        while(current != null) {
            if(count == index) {
                return current.data;
            }
            count++;
            current = current.next;
        }
        throw new IndexOutOfBoundsException("Out of bounds. Get()");
    }

    @Override
    public boolean remove(T item) {
        if(head == null) {
            return false;
        }

        if(head.data.equals(item)) {
            head = head.next;
            return true;
        }

        Node<T> current = head;
        Node<T> previous = null;

        while(current != null) {
            if(current.data.equals(item)) {
                previous.next = current.next;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}

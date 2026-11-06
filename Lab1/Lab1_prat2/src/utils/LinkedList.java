package utils;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T extends Comparable<T>> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private Node<T> d;


    public LinkedList() {
        head = null;
        tail = null;
        d = null;
    }

    public T Get() {
        return d.Data;
    }

    private void SetBegin(T object) {
        head = new Node<T>(object, head);
    }

    public void push_back (T object) {
        if(head == null) {
            SetBegin(object);
            return;
        } else {
            Node<T> node = new Node<T>(object, null);
            Node<T> temp = head;
            while(temp.Next != null) {
                temp = temp.Next;
            }
            temp.Next = node;
        }
    }


    public void sort()
    {
        for (Node<T> d1 = head; d1.Next != null; d1 = d1.Next)
        {
            Node<T> minv = d1;
            for (Node<T> d2 = d1; d2 != null; d2 = d2.Next)
                if (minv.Data.compareTo(d2.Data) < 0)
                    minv = d2;

            T temp = d1.Data;
            d1.Data = minv.Data;
            minv.Data = temp;
        }
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {return current != null;}

            @Override
            public T next() {
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.Data;
                current = current.Next;
                return data;
            }
        };
    }
}

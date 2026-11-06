package com.ktu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;


public class LinkedListQueue<E>
        implements Queue<E> {

    private Node<E> first;   // rodyklė į pirmą mazgą
    private int size = 0;        // sąrašo dydis, tuo pačiu elementų skaičius
    private Node<E> last;

    /**
     * Constructs an empty list.
     */
    public LinkedListQueue() {
    }

    /**
     * Vidinė mazgo klasė
     *
     * @param <E> mazgo duomenų tipas
     */
    private static class Node<E> {

        private E element;    // ji nematoma už klasės ListKTU ribų
        private Node<E> next; // next - kaip įprasta - nuoroda į kitą mazgą

        Node(E data, Node<E> next) { //mazgo konstruktorius
            this.element = data;
            this.next = next;
        }

        /**
         * Suranda sąraše k-ąjį mazgą
         *
         * @param k ieškomo mazgo indeksas (prasideda nuo 0)
         * @return surastas mazgas
         */
        public Node<E> findNode(int k) {
            Node<E> e = this;
            for (int i = 0; i < k; i++) {
                e = e.next;
            }
            return e;
        }
    } // klasės Node pabaiga


    /**
     * pridėda naują elementą į eilės galą.
     *
     * @return pridėtas elementas.
     */
    @Override
    public void enqueue(E item) {
        Node<E> newNode = new Node<>(item, null);
        if(isEmpty()) {
            first = last = newNode; // newNode = last; first = last;
        }
        else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    /**
     * išima pirma elementą ir gražina.
     *
     * @return pašalintas elementas.
     */
    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        E item = first.element;
        first = first.next;
        if(first == null) {
            last = null;
        }
        size--;
        return item;
    }

    /**
     * gražina pirma eilėje esantį elementą.
     *
     * @return pašalintas elementas.
     */
    @Override
    public E peak() {
        if(isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return first.element;
    }

    /**
     * patikrina ar eilė tuščia
     *
     * @return boolean reikšme.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}

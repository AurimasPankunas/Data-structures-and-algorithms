package com.ktu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;


public class LinkedListStack<E>
        implements Stack<E> {

    private Node<E> first;   // rodyklė į pirmą mazgą
    private int size = 0;        // sąrašo dydis, tuo pačiu elementų skaičius

    /**
     * Constructs an empty list.
     */
    public LinkedListStack() {
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
     * išima pirma elementą.
     *
     * @return pašalintas elementas.
     */
    @Override
    public E pop() {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        E item = first.element;
        first = first.next;
        size--;
        return item;
    }

    /**
     * įterpia naują elementą steko viršuje.
     *
     *
     * @return E item iterptas elementas.
     */
    @Override
    public void push(E item) {
        first = new Node<E>(item, first);
        size++;
    }

    /**
     * gražina pirma elementa steko.
     *
     * @return pirmo steko elemento reikšmė.
     */
    @Override
    public E peek() {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return first.element;
    }


    /**
     * patikrina ar stekas tuščias.
     *
     * @return boolean reikšme (true - tuščia, false - netuščia).
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}

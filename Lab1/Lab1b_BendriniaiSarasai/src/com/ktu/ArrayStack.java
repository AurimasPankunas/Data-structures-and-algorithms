package com.ktu;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class ArrayStack<E>
        implements Stack<E> {

    private ArrayList<E> elements;

    public ArrayStack() {
        elements = new ArrayList<>();
    }


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
        return elements.remove(elements.size() - 1);
    }

    /**
     * įterpia naują elementą steko viršuje.
     *
     *
     * @return E item iterptas elementas.
     */
    @Override
    public void push(E item) {
        elements.add(item);
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
        return elements.get(elements.size() - 1);
    }


    /**
     * patikrina ar stekas tuščias.
     *
     * @return boolean reikšme (true - tuščia, false - netuščia).
     */
    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }
}

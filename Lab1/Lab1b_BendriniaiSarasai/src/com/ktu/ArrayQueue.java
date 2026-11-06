package com.ktu;

import java.util.ArrayList;


public class ArrayQueue<E> implements Queue<E> {
    private ArrayList<E> elements;

    public ArrayQueue() {
        elements = new ArrayList<>();
    }

    /**
     * pridėda naują elementą į eilės galą.
     *
     * @return pridėtas elementas.
     */
    @Override
    public void enqueue(E item) {
        elements.add(item);
    }

    /**
     * išima pirma elementą ir gražina.
     *
     * @return pašalintas elementas.
     */
    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements.remove(0);
    }

    /**
     * gražina pirma eilėje esantį elementą.
     *
     * @return gražintas elementas.
     */
    @Override
    public E peak() {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements.get(0);
    }
    
    /**
     * patikrina ar eilė tuščia
     *
     * @return boolean reikšme.
     */
    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    /**
     * gražina paskutinį eilėje esanti elementą
     *
     * @return gražintas elementas.
     */
    public E peeklast() {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements.get(elements.size() - 1);
    }

    /**
     * išima paskutinį elementą ir gražina.
     *
     * @return pašalintas elementas.
     */
    public E dequeuelast() {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements.remove(elements.size() - 1);
    }
}

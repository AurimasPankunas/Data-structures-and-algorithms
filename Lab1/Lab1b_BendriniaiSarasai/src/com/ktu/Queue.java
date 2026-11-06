package com.ktu;

public interface Queue<E> {
    /**
     * pridėda naują elementą į eilės galą.
     *
     * @return pridėtas elementas.
     */
    void enqueue(E item);

    /**
     * išima pirma elementą ir gražina.
     *
     * @return pašalintas elementas.
     */
    E dequeue();

    /**
     * gražina pirma eilėje esantį elementą.
     *
     * @return pašalintas elementas.
     */
    E peak();

    /**
     * patikrina ar eilė tuščia
     *
     * @return boolean reikšme.
     */
    boolean isEmpty();
}

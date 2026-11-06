package com.ktu;

public interface Stack<E> {
    /**
     * išima pirma elementą.
     *
     * @return pašalintas elementas.
     */
    E pop();

    /**
     * įterpia naują elementą steko viršuje.
     *
     *
     * @return E item iterptas elementas.
     */
    void push(E item);

    /**
     * gražina pirma elementa steko.
     *
     * @return pirmo steko elemento reikšmė.
     */
    E peek();

    /**
     * patikrina ar stekas tuščias.
     *
     * @return boolean reikšme (true - tuščia, false - netuščia).
     */
    boolean isEmpty();
}
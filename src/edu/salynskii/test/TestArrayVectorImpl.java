package edu.salynskii.test;

import ru.ncedu.java.tasks.ArrayVectorImpl;

/**
 * Created by Alimantu on 21/10/15.
 */
public class TestArrayVectorImpl {
    public static void main(String[] args) {
        ArrayVectorImpl arrayVector = new ArrayVectorImpl();
        arrayVector.set(-2);
        //System.out.println(arrayVector.get(1));
        System.out.println(arrayVector.getMax());
        System.out.println(arrayVector.getNorm());
    }
}

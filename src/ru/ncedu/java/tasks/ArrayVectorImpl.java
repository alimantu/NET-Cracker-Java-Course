package ru.ncedu.java.tasks;

import java.util.Arrays;

/**
 * Created by Alimantu on 21/10/15.
 */
public class ArrayVectorImpl implements ArrayVector {
    double[] elements;
    int length;

    public ArrayVectorImpl() {
        elements = null;
        length = 0;
    }

    public ArrayVectorImpl(double... elements) {
        this.elements = elements.clone();
        length = elements.length;
    }

    @Override
    public void set(double... elements) {
        this.elements = elements.clone();
        length = elements.length;
    }

    @Override
    public double[] get() {
        return elements;
    }

    @Override
    public ArrayVector clone() {
        return new ArrayVectorImpl(elements);
    }

    @Override
    public int getSize() {
        return length;
    }

    @Override
    public void set(int index, double value) {
        if (index >= 0) {
            if (index > length - 1) {
                double[] newElements = new double[index + 1];
                System.arraycopy(elements, 0, newElements, 0, length);
                elements = newElements;
                length = index + 1;
            }
            elements[index] = value;
        }
    }

    @Override
    public double get(int index) throws ArrayIndexOutOfBoundsException {
        if (length != 0) {
            return elements[index];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public double getMax() {
        double max = - Double.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            max = max < elements[i] ? elements[i] : max;
        }
        return max;
    }

    @Override
    public double getMin() {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            min = min < elements[i] ? min : elements[i];
        }
        return min;
    }

    @Override
    public void sortAscending() {
        Arrays.sort(elements);
    }

    @Override
    public void mult(double factor) {
        for (int i = 0; i < length; i++) {
            elements[i] *= factor;
        }
    }

    @Override
    public ArrayVector sum(ArrayVector anotherVector) {
        int tmpLength = length <= anotherVector.getSize() ?
                length : anotherVector.getSize();
        for (int i = 0; i < tmpLength; i++) {
            elements[i] += anotherVector.get(i);
        }
        return this;
    }

    @Override
    public double scalarMult(ArrayVector anotherVector) {
        double result = 0;
        int tmpLength = length <= anotherVector.getSize() ?
                length : anotherVector.getSize();
        for (int i = 0; i < tmpLength; i++) {
            result += elements[i] * anotherVector.get(i);
        }
        return result;
    }

    @Override
    public double getNorm() {
        return Math.sqrt(scalarMult(this));
    }
}

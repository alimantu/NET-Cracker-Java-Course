package com.netcracker.edu.java.tasks;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Alimantu on 21/10/15.
 */
public class ComplexNumberImpl implements ComplexNumber {
    private double re;
    private double im;

    public ComplexNumberImpl() {
        re = 0;
        im = 0;
    }

    public ComplexNumberImpl(double re, double im){
        set(re, im);
    }

    public ComplexNumberImpl(String value){
        set(value);
    }

    @Override
    public double getRe() {
        return re;
    }

    @Override
    public double getIm() {
        return im;
    }

    @Override
    public boolean isReal() {
        return im == 0;
    }

    @Override
    public void set(double re, double im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public void set(String value) throws NumberFormatException {
        String tmpValue = value.replace(" ", "");
        int iIndex = tmpValue.indexOf("i");
        if (iIndex != -1) {
            if (iIndex < tmpValue.length() - 1) {
                throw new NumberFormatException();
            }
            int index = indexOfImPart(tmpValue);
            String suff = "";
            re = 0;
            if (index != 0) {
                re = Double.parseDouble(tmpValue.substring(0, index));
            }
            if (index + 1 >= iIndex) {
                suff = "1";
            }
            im = Double.parseDouble(tmpValue.substring(index, iIndex) + suff);
        } else {
            im = 0;
            re = Double.parseDouble(tmpValue);
        }
    }

    private int indexOfImPart(String value) {
        if (value.length() < 3) {
            return 0;
        }
        return Math.max(Math.max(value.indexOf("+", 1), value.indexOf("-", 1)), 0);
    }

    @Override
    public String toString(){
        String strRe = "";
        String strIm = "";
        if (re != 0) {
            strRe = Double.toString(re);
        }
        if (im != 0) {
            strIm = re != 0 ? (im > 0 ? "+" : "-") : (im < 0 ? "-" : "");
            strIm += Double.toString(Math.abs(im));
            strIm += "i";
        }
        return strRe + strIm;
    }

    @Override
    public ComplexNumber copy() {
        return new ComplexNumberImpl(re, im);
    }

    @Override
    public ComplexNumber clone() throws CloneNotSupportedException {
        return copy();
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof ComplexNumber
                && new Double(re).equals(((ComplexNumber) other).getRe())
                && new Double(im).equals(((ComplexNumber) other).getIm());
    }

    @Override
    public int compareTo(ComplexNumber other) {
        Double absCompl = Math.pow(re, 2) + Math.pow(im, 2);
        return absCompl.compareTo(Math.pow(other.getIm(), 2) + Math.pow(other.getRe(), 2));
    }

    @Override
    public void sort(ComplexNumber[] array) {
        Comparator<ComplexNumber> comparator = new Comparator<ComplexNumber>() {
            @Override
            public int compare(ComplexNumber o1, ComplexNumber o2) {
                return o1.compareTo(o2);
            }
        };
        Arrays.sort(array, comparator);
    }

    @Override
    public ComplexNumber negate() {
        re = -re;
        im = -im;
        return this;
    }

    @Override
    public ComplexNumber add(ComplexNumber arg2) {
        re += arg2.getRe();
        im += arg2.getIm();
        return this;
    }

    @Override
    public ComplexNumber multiply(ComplexNumber arg2) {
        double tmpRe = re * arg2.getRe() - im * arg2.getIm();
        im = im * arg2.getRe() + re * arg2.getIm();
        re = tmpRe;
        return this;
    }
}

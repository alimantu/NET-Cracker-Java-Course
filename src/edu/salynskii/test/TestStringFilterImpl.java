package edu.salynskii.test;

import ru.ncedu.java.tasks.StringFilterImpl;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Alimantu on 28/10/15.
 */
public class TestStringFilterImpl {
    public static void main(String[] args) {
        StringFilterImpl stringFilter = new StringFilterImpl();
        stringFilter.add("aaaabc");
        stringFilter.add("Aabc");
        stringFilter.add("Aaaabcd");
        stringFilter.add("aAaadcd");
        stringFilter.add("a13abc");
        stringFilter.add("aa2abc");
        stringFilter.add("a22abc");
        stringFilter.add(null);
        Iterator<String> iterator;

        // test for startingWith
        iterator = stringFilter.getStringsStartingWith("");

        // test for contains
//        iterator = stringFilter.getStringsContaining("cd");

        // test for numberFormat
//        iterator = stringFilter.getStringsByNumberFormat("a##abc");

        // test for byPattern
        iterator = stringFilter.getStringsByPattern("***a**b*d*");

        //iterator.forEachRemaining(System.out::println);

        System.out.println();
//        iterator = stringFilter.getStringsStartingWith("");
//        iterator.forEachRemaining(System.out::println);

    }
}

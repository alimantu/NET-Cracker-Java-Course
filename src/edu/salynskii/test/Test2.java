package edu.salynskii.test;

import ru.ncedu.java.tasks.ControlFlowStatements3Impl;

import java.util.Arrays;

/**
 * Created by Alimantu on 11/10/15.
 */
public class Test2 {
    public static void main(String[] args) {
        ControlFlowStatements3Impl cfs = new ControlFlowStatements3Impl();
        System.out.print(String.valueOf(cfs.getFunctionValue(3)) + " ");
        System.out.print(String.valueOf(cfs.getFunctionValue(-2)) + " ");
        System.out.println(String.valueOf(cfs.getFunctionValue(1.414)));

        System.out.print(cfs.decodeSeason(1) + " ");
        System.out.print(cfs.decodeSeason(4) + " ");
        System.out.print(cfs.decodeSeason(8) + " ");
        System.out.print(cfs.decodeSeason(11) + " ");
        System.out.println(cfs.decodeSeason(15));

        System.out.println(Arrays.deepToString(cfs.initArray()));

        System.out.println(cfs.getMaxProductIndex(new long[][]{{1, 2, 3}, {3, -5, -2}}));

        System.out.println(cfs.calculateLineSegment(1.2f, 6));
    }
}

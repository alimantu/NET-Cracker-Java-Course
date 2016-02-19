package edu.salynskii.test;

import ru.ncedu.java.tasks.ControlFlowStatements1Impl;

import java.util.Arrays;

/**
 * Created by Alimantu on 11/10/15.
 */
public class Test1 {
    public static void main(String[] args) {
        /*ControlFlowStatements1Impl cfs = new ControlFlowStatements1Impl();
        System.out.println(String.valueOf(cfs.getFunctionValue(3.14f)));
        System.out.println(String.valueOf(cfs.getFunctionValue(-1)));
        System.out.println(Arrays.deepToString(cfs.initArray()));
        System.out.println(cfs.getMinValue(new int[][]{{1, 2}, {3, -5}}));
        System.out.println(cfs.calculateBankDeposit(100).toString());*/
        Test1 test1 = new Test1();
        System.out.println(test1.getClass());
        System.out.println(test1.getClass().getSuperclass());
        System.out.println(test1.getClass().getSuperclass().getSuperclass());
    }
}

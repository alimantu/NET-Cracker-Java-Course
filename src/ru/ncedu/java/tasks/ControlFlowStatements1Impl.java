package ru.ncedu.java.tasks;

/**
 * Created by Alimantu on 11/10/15.
 */
public class ControlFlowStatements1Impl implements ControlFlowStatements1 {
    @Override
    public float getFunctionValue(float x) {
        return (float) (x > 0 ? 2 * Math.sin(x) : (6 - x));
    }

    @Override
    public String decodeWeekday(int weekday) {
        switch (weekday) {
            case 1 : return "Monday";
            case 2 : return "Tuesday";
            case 3 : return "Wednesday";
            case 4 : return "Thursday";
            case 5 : return "Friday";
            case 6 : return "Saturday";
            case 7 : return "Sunday";
            default: throw new IllegalArgumentException("Error in decodeWeekday: expected value from 1 to 7 but found " + weekday);
        }
    }

    @Override
    public int[][] initArray() {
        int[][] initArray = new int[8][5];
        for (int i = 0; i < initArray.length; i++) {
            for (int j = 0; j < initArray[i].length; j++) {
                initArray[i][j] = i * j;
            }
        }
        return initArray;
    }

    @Override
    public int getMinValue(int[][] array) {
        int min = Integer.MAX_VALUE;
        for (int[] subArray : array) {
            for (int elem : subArray) {
                min = Math.min(min, elem);
            }
        }
        return min;
    }

    @Override
    public BankDeposit calculateBankDeposit(double P) {
        BankDeposit bankDeposit = new BankDeposit();
        bankDeposit.amount = 1000;
        bankDeposit.years = 0;
        while (bankDeposit.amount < 5000) {
            bankDeposit.years++;
            bankDeposit.amount *= 1 + P / 100;
        }
        return bankDeposit;
    }
}

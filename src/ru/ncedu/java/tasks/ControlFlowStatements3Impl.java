package ru.ncedu.java.tasks;

/**
 * Created by Alimantu on 11/10/15.
 */
public class ControlFlowStatements3Impl implements ControlFlowStatements3 {
    @Override
    public double getFunctionValue(double x) {
        double value = 0;
        if (x >= 2) {
            value = 4;
        } else if (x <= 0) {
            value = -x;
        } else {
            value = Math.pow(x, 2);
        }
        return value;
    }

    /*
    Вернуть название соответствующего времени года ("Winter", "Spring", "Summer", "Autumn")
    или строку "Error", если monthNumber не лежит в диапазоне 1–12.
    */
    @Override
    public String decodeSeason(int monthNumber) {
        String season = "";
        switch (monthNumber) {
            case 12:case 1:case 2:
                season = "Winter";
                break;
            case 3:case 4:case 5:
                season = "Spring";
                break;
            case 6:case 7:case 8:
                season = "Summer";
                break;
            case 9:case 10:case 11:
                season = "Autumn";
                break;
            default:
                season = "Error";
        }
        return season;
    }

    @Override
    public long[][] initArray() {
        long[][] initArray = new long[8][5];
        for (int i = 0; i < initArray.length; i++) {
            for (int j = 0; j < initArray[i].length; j++) {
                initArray[i][j] = (long) Math.pow(Math.abs(i - j), 5);
            }
        }
        return initArray;
    }

    @Override
    public int getMaxProductIndex(long[][] array) {
        long max = Long.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < array.length; i++) {
            long value = 1;
            for (long elem : array[i]) {
                value *= elem;
            }
            if (value > max) {
                max = value;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    @Override
    public float calculateLineSegment(float A, float B) {
        float segment = A;
        while (Float.compare(segment, B) >= 0) {
            segment -= B;
        }
        return segment;
    }
}

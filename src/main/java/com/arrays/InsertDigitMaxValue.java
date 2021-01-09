package com.arrays;

import java.util.LinkedList;
import java.util.List;

public class InsertDigitMaxValue {
    public int solution(int num) {
        List<Integer> numInArr = getArrayFromNumber(Math.abs(num));

        insert5(numInArr, num);

        return convertListToNumber(numInArr, num);
    }

    private void insert5(final List<Integer> numInArr, final int num) {
        int index = numInArr.size();
        boolean isPositive = num >= 0;
        for (int i = 0; i < numInArr.size(); i++) {
            if (isPositive && numInArr.get(i) <= 5) {
                index = i;
                break;
            } else if (!isPositive && numInArr.get(i) >= 5) {
                index = i;
                break;
            }
        }

        numInArr.add(index, 5);
    }

    private int convertListToNumber(List<Integer> numInArr, final int num) {
        int result = 0;
        int tens = (int) Math.pow(10, numInArr.size() - 1);
        for (int digit : numInArr) {
            result += digit * tens;
            tens /= 10;
        }
        return num >= 0 ? result : result * -1;
    }

    private List<Integer> getArrayFromNumber(int num) {
        List<Integer> result = new LinkedList<>();
        int degree = getDegree(num);
        int divisor = (int) Math.pow(10, degree - 1);
        while (divisor > 0) {
            int digit = num / divisor;
            result.add(digit);
            num %= divisor;
            divisor = divisor / 10;
        }

        return result;
    }

    private int getDegree(int num) {
        if (num == 0) return 1;
        int counter = num;
        int degree = 0;
        while (counter != 0) {
            counter /= 10;
            degree++;
        }
        return degree;
    }

    public static void main(String[] args) {
        InsertDigitMaxValue i = new InsertDigitMaxValue();
        System.out.println(i.solution(268));
        System.out.println(i.solution(670));
        System.out.println(i.solution(0));
        System.out.println(i.solution(-999));
    }
}

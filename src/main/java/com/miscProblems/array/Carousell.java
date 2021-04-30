package com.miscProblems.array;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Carousell {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputs = input.split(",");

        System.out.println(findHighestEarningStreak(inputs));

    }

    public static int findHighestEarningStreak(final String[] rawInput) {
        int[] input;

        try {
            input = cleanInput(rawInput);
        } catch (IllegalArgumentException exc) {
            return 0;
        }

        if (input == null || input.length == 0) {
            return 0;
        }
        int currentMaxStreakContiguous = input[0];
        int maxStreak = input[0];
        for (int i = 1; i < input.length; i++) {
            currentMaxStreakContiguous = Math.max(input[i] + currentMaxStreakContiguous, input[i]);
            maxStreak = Math.max(currentMaxStreakContiguous, maxStreak);
        }
        return Math.max(maxStreak, 0);
    }

    private static int[] cleanInput(final String[] inputs) {
        List<Integer> cleanedInput = Arrays.stream(inputs)
            .map(String::trim)
            .filter(s -> {
                if (s.isEmpty()) {
                    throw new IllegalArgumentException();
                }

                try {
                    Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    return false;
                }

                return true;
            })
            .map(Integer::valueOf)
            .collect(Collectors.toList());
        int[] arr = new int[cleanedInput.size()];
        for (int i = 0; i < cleanedInput.size(); i++) {
            arr[i] = cleanedInput.get(i);
        }
        return arr;
    }

}

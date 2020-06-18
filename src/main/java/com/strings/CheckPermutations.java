package com.strings;

import java.util.Arrays;

public class CheckPermutations {
    public static void main(String[] args) {
        String str1 = "abcdefgh";
        String str2 = "fghabced";
        System.out.println(isPermutation(str1, str2));
        System.out.println(isPermutationEnhanced(str1, str2));

        str1 = "abcdefg";
        str2 = "abcdefz";
        System.out.println(isPermutation(str1, str2));
        System.out.println(isPermutationEnhanced(str1, str2));
    }

    private static boolean isPermutation(final String str1, final String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] str1Arr = str1.toCharArray();
        Arrays.sort(str1Arr);
        char[] str2Arr = str2.toCharArray();
        Arrays.sort(str2Arr);
        return (new String(str1Arr)).equals(new String(str2Arr));
    }

    private static boolean isPermutationEnhanced(final String str1, final String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] letters = new int[128];

        for (int i = 0; i < str1.length(); i++) {
            letters[str1.charAt(i)]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            char currentLetter = str2.charAt(i);
            letters[currentLetter]--;
            if (letters[currentLetter] < 0)
                return false;
        }
        return true;
    }
}

package com.miscProblems.array;

public class Caraousel2 {

    public static int solution(String s, String t) {
        boolean isDiv = findIfSIsDivByT(s, t);

        if (!isDiv) {
            return -1;
        }

        return findPrefixLengthInSmaller(s.length() > t.length() ? s : t);
    }

    private static int findPrefixLengthInSmaller(final String s) {

        for (int i = 0; i < s.length() / 2 ; i++) {
            String prefix = "";
            String subStr = s.substring(0, i+1);
            while (prefix.length() < s.length()) {
                prefix += subStr;
            }

            if (prefix.equals(s)) {
                return subStr.length();
            }
        }

        return s.length();
    }

    private static boolean findIfSIsDivByT(final String s, final String t) {
        String larger = s.length() > t.length() ? s : t;
        String smaller = s.length() > t.length() ? t : s;

        if(larger.length()%smaller.length() >0) {
            return false;
        }
        int smallIndex = 0;
        int largeIndex = 0;
        while (largeIndex < larger.length()) {

            if (larger.charAt(largeIndex) == smaller.charAt(smallIndex)) {
                if (smallIndex == smaller.length() - 1) {
                    smallIndex = 0;
                } else {
                    smallIndex++;
                }
                largeIndex++;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        //        System.out.println(solution("lrbb", "lrbb"));
        System.out.println(solution("rbrb", "rbrb"));
    }
}

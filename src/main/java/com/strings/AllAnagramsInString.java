package com.strings;

import java.util.ArrayList;

/**
 * Two com.strings are anagrams of each other if the letters of one com.string can be rearranged to form the other com.string.
 * Given a com.string, find the number of pairs of substrings of the com.string that are anagrams of each other.
 *
 * For example :
 * cdcd:
 *      (c, c)
 *      (d, d)
 *      (cd, dc)
 *      (cd, cd)
 *      (dc, cd)
 *
 *  ifailuhkqq:
 *      (i, i)
 *      (q, q)
 *      (ifa, fai)
 */
public class AllAnagramsInString {
    static int sherlockAndAnagrams(String s) {
        int count = 0;
        for (int i = 1; i <= s.length() - 1; i++) {
            ArrayList<String> substrings = new ArrayList<>();

            for (int j = 0; j <= s.length() - i; j++) {
                substrings.add(s.substring(j, j + i));
            }

            for (int j = 0; j < substrings.size(); j++) {
                for (int k = j + 1; k < substrings.size(); k++) {
                    if (Anagrams.isAnagram(substrings.get(j), substrings.get(k))) {
                        System.out.printf("\n (%s, %s)", substrings.get(j), substrings.get(k));
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(AllAnagramsInString.sherlockAndAnagrams("cdcd"));
        System.out.println(AllAnagramsInString.sherlockAndAnagrams("ifailuhkqq"));
    }
}

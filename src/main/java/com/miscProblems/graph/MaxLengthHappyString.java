package com.miscProblems.graph;

/**
 * A string is called happy if it does not have any of the strings 'aaa', 'bbb' or 'ccc' as a substring.
 *
 * Given three integers a, b and c, return any string s, which satisfies following conditions:
 *
 * s is happy and longest possible.
 * s contains at most a occurrences of the letter 'a', at most b occurrences of the letter 'b' and at most c occurrences of the letter 'c'.
 * s will only contain 'a', 'b' and 'c' letters.
 * If there is no such string s return the empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: a = 1, b = 1, c = 7
 * Output: "ccaccbcc"
 * Explanation: "ccbccacc" would also be a correct answer.
 * Example 2:
 *
 * Input: a = 2, b = 2, c = 1
 * Output: "aabbc"
 * Example 3:
 *
 * Input: a = 7, b = 1, c = 0
 * Output: "aabaa"
 * Explanation: It's the only correct answer in this case.
 *
 *
 * Constraints:
 *
 * 0 <= a, b, c <= 100
 * a + b + c > 0
 */
public class MaxLengthHappyString {
    public String sol(int A, int B, int C) {
        Character currentChar, previousChar;
        if (A > B & A > C) {
            currentChar = 'a';
        } else if (B > A & B > C) {
            currentChar = 'b';
        } else {
            currentChar = 'c';
        }
        StringBuilder out = new StringBuilder();
        while (A + B + C > 0) {
            previousChar = out.length() > 0 ? out.charAt(out.length() - 1) : null;
            //Append one character of current element
            if (currentChar == 'a') {
                out.append("a");
                A--;
            } else if (currentChar == 'b') {
                out.append("b");
                B--;
            } else {
                out.append("c");
                C--;
            }

            //Choose next element logic
            currentChar = chooseNextElement(previousChar, currentChar, A, B, C);

            if (currentChar == null) {
                break;
            }
        }

        return out.toString();
    }

    private Character chooseNextElement(final Character previousChar, final Character currentChar, final int a, final int b, final int c) {
        if (previousChar != currentChar) {
            //choose max of all 3 characters and return that character
            if (a >= b && a >= c && a > 0) {
                return 'a';
            } else if (b >= a & b >= c & b > 0) {
                return 'b';
            } else if (c > 0) {
                return 'c';
            }
        } else {
            //choose max of remaining 2 characters and return that character
            if (currentChar == 'a') {
                //choose max of b and c and return
                if (b >= c && b > 0) {
                    return 'b';
                } else if (c > 0) {
                    return 'c';
                }
            } else if (currentChar == 'b') {
                //choose max of a and c and return
                if (a >= c & a > 0) {
                    return 'a';
                } else if (c > 0) {
                    return 'c';
                }

            } else {
                //choose max of a and b and return
                if (a >= b & a > 0) {
                    return 'a';
                } else if (b > 0) {
                    return 'b';
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MaxLengthHappyString s = new MaxLengthHappyString();
        System.out.println("A6,B1,C1 = " + s.sol(6, 1, 1));
        System.out.println("A1,B3,C1 = " + s.sol(1, 3, 1));
        System.out.println("A0,B1,C8 = " + s.sol(0, 1, 8));
        System.out.println("A0,B0,C0 = " + s.sol(0, 0, 0));
        System.out.println("A0,B3,C20 = " + s.sol(0, 3, 20));
    }
}

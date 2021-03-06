package com.miscProblems.stackBased;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * Example 2:
 *
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * Example 3:
 *
 * Input: s = ""
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 3 * 104
 * s[i] is '(', or ')'.
 */
public class LongestValidParentheses {
    public static int solution(String s) {
        Stack<Integer> stk = new Stack<>();
        int[] sumArr = new int[s.length()];
        int[] stkTopIndex = new int[s.length()];

        Map<Integer, List<Integer>> sumMap = new HashMap<>();

        int currCount = 0;
        for(int i=0; i< s.length(); i++) {
            if(s.charAt(i) == '(') {
                stk.push(i);
                currCount += 1;
                sumArr[i] = currCount;

            } else {
                if(!stk.isEmpty())
                    stk.pop();
                currCount -= 1;
                sumArr[i] = currCount;

            }
            stkTopIndex[i] = stk.isEmpty() ? -1 : stk.peek();
            if(!sumMap.containsKey(sumArr[i])) {
                sumMap.put(sumArr[i], new ArrayList<>());
            }
            sumMap.get(sumArr[i]).add(i);
        }

        int longest = 0;
        for(int i=1; i<s.length(); i++) {
            for(int j=0; j<sumMap.get(sumArr[i]).size(); j++) {
                if(sumMap.get(sumArr[i]).get(j) < i) {
                    if(stkTopIndex[i] == stkTopIndex[sumMap.get(sumArr[i]).get(j)]) {
                        longest = Math.max(longest, i - sumMap.get(sumArr[i]).get(j));
                    }
                }
            }

            if(sumArr[i] == 0 && stkTopIndex[i] == -1) {
                longest = Math.max(longest, i+1);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        System.out.println(solution(")()())"));
    }
}

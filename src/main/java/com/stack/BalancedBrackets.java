package com.stack;

import java.util.Stack;

/**
 * A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].
 *
 * Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left
 * of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of
 * brackets: [], {}, and ().
 *
 * A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])
 * } is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a
 * single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square
 * bracket, ].
 *
 * By this logic, we say a sequence of brackets is balanced if the following conditions are met:
 *
 * It contains no unmatched brackets.
 * The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
 * Given  n com.strings of brackets, determine whether each sequence of brackets is balanced. If a com.string is balanced,
 * return YES. Otherwise, return NO.
 */
public class BalancedBrackets {

    static String isBalanced(String s) {
        Stack<Character> stk = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                stk.push(c);
            }

            if (c == '}' || c == ')' || c == ']') {
                if (stk.isEmpty()) {
                    return "NO";
                }
                char popped = stk.pop();
                if (c == '}' && popped != '{') {
                    return "NO";
                }

                if (c == ')' && popped != '(') {
                    return "NO";
                }

                if (c == ']' && popped != '[') {
                    return "NO";
                }
            }
        }

        if (!stk.isEmpty()) {
            return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {
        test("{(([])[])[]}");
        test("{(([])[])[]]}");
        test("{(([])[])[]}[]");
    }

    public static void test(String s) {
        System.out.println(isBalanced(s));
    }
}

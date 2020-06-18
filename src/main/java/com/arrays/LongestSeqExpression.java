package com.arrays;

import java.util.Stack;

/**
 * Created by Kshitiz on 2/5/2019.
 */
public class LongestSeqExpression {
  static class Pair {
    private int start;
    private int end;

    public Pair() {
      this.start = -1;
      this.end = -1;
    }

    public int getStart() {
      return start;
    }

    public void setStart(int start) {
      this.start = start;
    }

    public int getEnd() {
      return end;
    }

    public void setEnd(int end) {
      this.end = end;
    }

    public int getLength() {
      return start == end ? 0 : end - start + 1;
    }
  }

  /**
   *
   * @param input
   * @return Pair object denoting the indexes of longest valid substring, pair object will
   * have negative indices in case no valid substring is found
   * @throws Exception
   */
  public static Pair get(String input) throws Exception {
    int maxLength = 0;
    Pair pair = new Pair();
    int offset = 0;
    int currEnd = -1;
    Stack<Character> stk = new Stack<Character>();

    if (input.length() <= 1) return pair;
    for (int i = 0; i < input.length(); i++) {
      char ch = input.charAt(i);
      if (ch == ')') {
        if (stk.isEmpty()) {
          offset++;
        } else {
          stk.pop();
          currEnd = i;
          maxLength = Math.max(maxLength, currEnd - (stk.size() + offset) + 1);
          pair.setEnd(currEnd);
          pair.setStart((stk.size() + offset));
        }
      } else if (ch == '(') {
        stk.push(ch);
      } else {
        throw new Exception("Unidentified characters found");
      }
    }
    return pair;
  }

  public static void main(String[] args) {
    try{
      System.out.println("*******TEST CASE 1*******");
      String testString = "))((())";
      Pair pair = LongestSeqExpression.get(testString);
      printOutput(testString, pair);

      System.out.println("*******TEST CASE 2*******");
      testString = "))()(()))))((";
      pair = LongestSeqExpression.get(testString);
      printOutput(testString, pair);

      System.out.println("*******TEST CASE 3*******");
      testString = ")))(((";
      pair = LongestSeqExpression.get(testString);
      printOutput(testString, pair);

      System.out.println("*******TEST CASE 4*******");
      testString = ")";
      pair = LongestSeqExpression.get(testString);
      printOutput(testString, pair);

      System.out.println("*******TEST CASE 5*******");
      testString = ")k((()";
      pair = LongestSeqExpression.get(testString);
      printOutput(testString, pair);

    } catch (Exception e) {
      System.out.println("Exception cause = " + e.getMessage());
    }
  }

  private static void printOutput(String testString, Pair pair) {
    System.out.println("Length of longest valid sub com.string is = " + pair.getLength());
    if (pair.getLength() > 1) {
      System.out.println("start = " + pair.getStart() + ", end = " + pair.getEnd());
      System.out.println("longest valid substring is = " + testString.substring(pair.getStart(), pair.getEnd() + 1));
    }
  }
}

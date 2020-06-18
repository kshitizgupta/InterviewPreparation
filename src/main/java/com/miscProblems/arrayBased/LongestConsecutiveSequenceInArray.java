package com.miscProblems.arrayBased;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Ques: Given an array say [2,1,6,9,4,3]
 * Longest consecutive sequence is 1,2,3,4 of length 4
 *
 * To find a sequence at any no. we need to see the numbers less than it
 * and equal to it. So if we put all current nos. into a map, then for any no.
 * we can navigate backwards to see the sequence and forward to see the sequence. Also
 * if we mark the nos. as visited then we avoid recomputing each element more than once.
 * So if once it is taken into a sequence we need not compute sequence for that again.
 *
 * Below is the algo
 */
public class LongestConsecutiveSequenceInArray {
    public static List<Integer> getLongestConsecutiveSeq(Integer[] arr) throws Exception {
        Map<Integer, Boolean> valToVisitedMap = new HashMap<>();

        Arrays.asList(arr).forEach(k -> valToVisitedMap.put(k, false));

        List<List<Integer>> sequences = new ArrayList<>();

        valToVisitedMap.forEach((key, value) -> {
            int currVal = key;
            boolean isCurrVisited = value;

            if (isCurrVisited)
                return;

            LinkedList<Integer> currSeq = new LinkedList<>();

            //Trace backwards
            currSeq.add(currVal);
            int prevVal = currVal - 1;
            while (true) {
                if (valToVisitedMap.containsKey(prevVal)) {
                    currSeq.add(prevVal);
                    valToVisitedMap.put(prevVal, true);
                    prevVal--;
                } else {
                    break;
                }
            }

            //Trace forward
            int nextVal = currVal + 1;
            while (true) {
                if (valToVisitedMap.containsKey(nextVal)) {
                    currSeq.add(nextVal);
                    valToVisitedMap.put(nextVal, true);
                    nextVal++;
                } else {
                    break;
                }
            }

            sequences.add(currSeq);
        });

        return sequences.stream().max(Comparator.comparing(List::size)).orElseThrow(Exception::new);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getLongestConsecutiveSeq(new Integer[]{2, 1, 6, 9, 4, 3}));
    }
}

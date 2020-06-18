package com.strings;

import java.util.HashMap;

public class Anagrams {
    static boolean isAnagram(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c: s1.toCharArray()){
            if(!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }

        for(char c: s2.toCharArray()) {
            if(!map.containsKey(c)) {
                return false;
            }

            map.put(c, map.get(c) - 1);

            if(map.get(c) == 0) {
                map.remove(c);
            } else if(map.get(c)<1){
                return false;
            }
        }

        if(map.size() != 0) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("aba", "bacc"));
    }
}

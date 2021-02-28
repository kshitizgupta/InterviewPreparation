package javaInterview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCache {
    private static int CACHE_SIZE = 3;
    private Map<Integer, Integer> map = new HashMap<>(CACHE_SIZE);
    private List<Integer> list = new LinkedList<>();

    public void put(final int key, final int value) {
        /**
         * 1. if the map doesnt have the no. execute eviction policy
         */

        if (!map.containsKey(key)) {
            map.put(key, value);
            list.add(key);
        }
        updateRecetlyUsed(key);
        evict();
    }

    private void evict() {
        if (map.size() > CACHE_SIZE) {
            final int key = list.remove(0);
            map.remove(key);
        }
    }

    private void updateRecetlyUsed(final int key) {
        list.add(list.remove(list.indexOf(key)));
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            updateRecetlyUsed(key);
        }
        return map.get(key);
    }

    public void display() {
        System.out.println(list);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache();

        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);

        cache.display();

        cache.put(4, 4);
        cache.display();

        /**
         * 1,2,3
         *
         * 2,3,4
         *
         * 4-->2-->1
         *
         */
        cache.put(2, 2);
        cache.display();
        cache.put(1, 1);
        cache.display();
    }
}

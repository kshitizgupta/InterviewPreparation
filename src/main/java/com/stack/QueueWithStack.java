package com.stack;

import java.util.Stack;

/**
 * A queue is an abstract data type that maintains the order in which elements were added to it, allowing the oldest
 * elements to be removed from the front and new elements to be added to the rear. This is called a
 * First-In-First-Out (FIFO) data structure because the first element added to the queue (i.e., the one that has been
 * waiting the longest) is always the first one to be removed.
 *
 * A basic queue has the following operations:
 *
 * Enqueue: add a new element to the end of the queue.
 * Dequeue: remove the element from the front of the queue and return it.
 * In this challenge, you must first implement a queue using two stacks. Then process  queries, where each query is
 * one of the following 3 types:
 *
 * 1 x: Enqueue element  into the end of the queue.
 * 2: Dequeue the element at the front of the queue.
 * 3: Print the element at the front of the queue.
 *
 * Solution:
 *
 * Time Complexity analysis
 * Enqueue: O(1) which is straightforward as we always push element on back stack
 * Dequeue: This is a bit more complex. When we dequeue we remove an element from front if front stack is not empty.
 * If not we then move all the elements from back to front and then remove the topmost element.
 * Transferring takes O(k) time if there were k elements in back stack. But once transferred all the k elements to front stack
 * we can do k-1 more dequeue operations without transferring back to front. Hence in totality the no. of transfers we need to do
 * to dequeue k elements is k. Hence the avg time complexity is O(1)
 *
 */
public class QueueWithStack {
    static class MyQueue<T> {
        private final Stack<T> back;
        private final Stack<T> front;

        public MyQueue() {
            back = new Stack<>();
            front = new Stack<>();
        }

        public void enqueue(T val) {
            back.push(val);
        }

        public T peek() {
            if (front.isEmpty()) {
                transfer(back, front);
            }
            return front.isEmpty() ? null : front.peek();
        }

        public T dequeue() {
            if (front.isEmpty() && back.isEmpty()) {
                return null;
            }
            if (front.isEmpty()) {
                transfer(back, front);
            }

            return front.pop();
        }

        private void transfer(Stack<T> from, Stack<T> to) {
            while (!from.isEmpty()) {
                to.push(from.pop());
            }
        }
    }
}
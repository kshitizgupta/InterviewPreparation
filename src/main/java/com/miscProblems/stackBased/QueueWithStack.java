package com.miscProblems.stackBased;

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

    public static void main(String[] args) {

    }
}
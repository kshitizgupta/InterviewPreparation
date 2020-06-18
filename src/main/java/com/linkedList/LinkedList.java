package com.linkedList;

public class LinkedList {
    Node head;

    public void addNode(int data) {
        Node newNode = new Node(data);
        newNode.data = data;
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
    }

    public void printLinkedList() {
        Node current = head;
        System.out.printf("\nPrinting linked list\t");
        while (current != null) {
            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.print("null\n");
    }

    public void reverse() {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = prev;

            prev = current;
            current = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addNode(1);
        ll.addNode(2);
        ll.addNode(3);
        ll.addNode(4);
        ll.addNode(5);

        ll.printLinkedList();

        ll.reverse();
        ll.printLinkedList();
    }
}

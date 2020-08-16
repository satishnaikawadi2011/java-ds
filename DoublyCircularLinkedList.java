package dataStructures;

public class DoublyCircularLinkedList {
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    };

    Node head;

    public void addBegin(int data) {
        Node n1 = new Node(data);
        if (head == null) {
            n1.next = n1;
            n1.prev = n1;
            head = n1;
            return;
        }

        n1.prev = head.prev;
        n1.next = head;
        head.prev.next = n1;
        head = n1;
    }

    public void addLast(int data) {
        Node n1 = new Node(data);
        if (head == null) {
            addBegin(data);
            return;
        }

        Node last = head.prev;
        // n1.prev = last;
        n1.next = head;
        head.prev = n1;
        n1.prev = last;
        last.next = n1;
    }

    public void removeLast() {
        Node temp = head;
        if (head == null) {
            System.out.println("Cannot remove from empty lsit !");
            return;
        }

        if (temp.next == head) {
            head = null;
            return;
        }

        Node last = head.prev;
        last.next = null;
        last.prev.next = head;
        last = last.prev;

    }

    public void removeStart() {
        Node temp = head;
        if (head == null) {
            System.out.println("Cannot remove from empty lsit !");
            return;
        }

        if (temp.next == head) {
            head = null;
            return;
        }
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        head = temp.next;
        temp.next = null;
        temp.prev = null;

    }

    public void print() {
        if (head == null) {
            System.out.println("The linked list is empty !");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // TODO: Driver Code
    // DoublyCircularLinkedList dcl = new DoublyCircularLinkedList();
    // // dcl.addBegin(1);
    // // dcl.addBegin(2);
    // // dcl.addBegin(3);
    // // dcl.addBegin(4);
    // dcl.addLast(5);
    // dcl.addLast(6);
    // dcl.addLast(7);
    // dcl.addLast(8);
    // // dcl.removeLast();
    // dcl.removeStart();
    // dcl.removeStart();
    // dcl.removeStart();
    // dcl.removeStart();
    // dcl.print();
}
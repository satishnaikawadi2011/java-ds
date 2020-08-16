package dataStructures;

/**
 * MyLinkedList
 */
public class MyLinkedList {

    public Node head;

    static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void pushFront(int data) {
        Node n1 = new Node(data);
        if (isEmpty()) {
            head = n1;
            return;
        }

        n1.next = head;
        head = n1;

    }

    public int popFront() {
        if (isEmpty()) {
            System.out.println("The list is already empty!");
            return 0;
        }
        int data2 = head.data;
        head = head.next;
        return data2;

    }

    public void print() {
        if (isEmpty()) {
            System.out.println("The list is empty !");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void pushBack(int data) {
        Node n1 = new Node(data);
        if (isEmpty()) {
            head = n1;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = n1;
        n1.next = null;
    }

    public int popBack() {
        if (isEmpty()) {
            System.out.println("The list is already empty !");
            return 0;
        }

        Node temp = head;

        // TODO: Corner case IMP
        if (temp.next == null) {
            head = null;
            return temp.data;
        }
        // TODO: Corner case IMP

        while (temp.next.next != null) {
            temp = temp.next;
        }
        int data2 = temp.next.data;
        temp.next = null;
        return data2;
    }

    public int length() {
        if (isEmpty()) {
            return 0;
        }

        Node temp = head;
        int i = 1;
        while (temp.next != null) {
            i++;
            temp = temp.next;
        }

        return i;
    }

    public void addAtIndex(int index, int data) {
        Node n1 = new Node(data);
        int length = length();
        if (index == 0) {
            pushFront(data);
            return;
        }
        // if (index == length - 1) {
        // pushBack(data);
        // return;
        // }
        if (index < 0 || index >= length) {
            System.out.println("The index is missing in the linked list !");
            return;
        }
        Node temp = head;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        n1.next = temp.next;
        temp.next = n1;
    }

    public boolean find(int data) {
        if (isEmpty()) {
            return false;
        }

        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    public void erase(int data) {
        if (isEmpty()) {
            System.out.println("The list is empty !");
            return;
        }

        if (!find(data)) {
            System.out.println("No node with given data !");
            return;
        }

        Node temp = head;
        if (temp.data == data) {
            popFront();
            return;
        }
        while (temp.next.data != data) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    public int getLast() {
        if (isEmpty()) {
            System.out.println("The list is empty !");
            return 0;
        }
        if (head.next == null) {
            return head.data;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp.data;
    }

    public void reverse() {
        if (isEmpty()) {
            System.out.println("The list is empty !");
            return;
        }
        Node current, prev, next;
        if (head.next == null) {
            return;
        }
        current = head;
        prev = null;
        next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void Addone() {
        String number = "";
        Node temp = head;
        while (temp != null) {
            number = number + Integer.toString(temp.data);
            temp = temp.next;
        }
        int n = Integer.parseInt(number);
        String finalNumber = Integer.toString(n + 1);
        // System.out.println(finalNumber);
        char[] arr = finalNumber.toCharArray();
        head = null;
        for (char c : arr) {
            // System.out.print(Integer.parseInt(String.valueOf(c)));
            pushBack(Integer.parseInt(String.valueOf(c)));
        }
        System.out.println();
    }

    // TODO: Driver Code
    // MyLinkedList l1 = new MyLinkedList();
    // l1.pushFront(2);
    // l1.pushFront(4);
    // l1.pushFront(6);
    // l1.pushBack(8);
    // l1.pushBack(10);
    // l1.print();
    // l1.reverse();
    // System.out.println(l1.getLast());
    // l1.erase(6);
    // System.out.println(l1.find(240));
    // l1.addAtIndex(5, 1);
    // System.out.println(l1.length());
    // System.out.println("The deleted node is " + l1.popBack());
    // l1.popFront();
    // l1.print();
}
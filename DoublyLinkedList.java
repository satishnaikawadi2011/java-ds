package dataStructures;

public class DoublyLinkedList {
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
        Node temp = new Node(data);
        temp.next = head;
        temp.prev = null;

        // TODO: IMP
        if (head != null) {
            head.prev = temp;
        }

        head = temp;
    }

    public void addLast(int data) {
        Node n1 = new Node(data);
        if (head == null) {
            addBegin(data);
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = n1;
        n1.prev = temp;
        n1.next = null;
    }

    public void print() {
        if (head == null) {
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

    public int length() {
        if (head == null)
            return 0;

        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void insertAt(int index, int data) {
        if (index < 0 || index >= length()) {
            System.out.println("the given index is missing in linked list !");
            return;
        }

        if (index == 0) {
            addBegin(data);
            return;
        }

        Node n1 = new Node(data);
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        n1.next = temp;
        n1.prev = temp.prev;
        temp.prev.next = n1;
        temp.prev = n1;

    }

    public void printReverse() {
        Node temp = head;
        if (head == null) {
            System.out.println("The list is empty !");
            return;
        }

        if (temp.next == null) {
            print();
            return;
        }

        while (temp.next != null) {
            temp = temp.next;
        }

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }

        System.out.println();
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("The list is empty , canoot remove from a empty list !");
            return;
        }

        Node temp = head;

        if (temp.next == null) {
            head = null;
            return;
        }

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.prev.next = null;
        temp.prev = null;
    }

    public void removeStart() {
        if (head == null) {
            System.out.println("The list is empty , canoot remove from a empty list !");
            return;
        }

        Node temp = head.next;

        if (temp == null) {
            head = null;
            return;
        }

        head = temp;
        temp.prev.next = null;
        temp.prev = null;
    }

    public void removeAtIndex(int index) throws Exception {
        if (head == null) {
            throw new Exception("Cannot remove from a empty list !");
        }

        if (index < 0 || index >= length()) {
            throw new Exception("The index is missing in the list !");
        }

        if (index == 0) {
            removeStart();
            return;
        }

        if (index == length() - 1) {
            removeLast();
            return;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.prev = null;
    }

    // DoublyLinkedList dl = new DoublyLinkedList();
    // // dl.addBegin(1);
    // // dl.addLast(1);
    // // dl.addBegin(3);
    // // dl.addLast(3);
    // dl.addLast(2);
    // dl.addLast(3);
    // dl.addLast(4);
    // dl.addLast(6);
    // dl.addBegin(1);
    // dl.insertAt(4, 5);
    // // dl.removeStart();
    // try {
    // dl.removeAtIndex(3);
    // } catch (Exception e) {
    // // TODO: handle exception
    // System.out.println(e);
    // }
    // dl.removeLast();
    // System.out.println(dl.length());
    // dl.printReverse();
    // dl.print();

}
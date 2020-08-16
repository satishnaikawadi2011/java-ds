package dataStructures;

public class CircularSinglyLinkedList {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    };

    Node last;

    public void addToEmpty(int data) {
        if (last != null)
            return;

        Node temp = new Node(data);
        last = temp;
        last.next = last;

    }

    public void addBegin(int data) {
        if (last == null) {
            addToEmpty(data);
            return;
        }

        Node temp = new Node(data);
        temp.next = last.next;
        last.next = temp;
    }

    public void addLast(int data) {
        if (last == null) {
            addToEmpty(data);
            return;
        }

        Node temp = new Node(data);
        temp.next = last.next;
        last.next = temp;
        last = temp;
    }

    public void print() {
        if (last == null) {
            System.out.println("The list is empty !");
            return;
        }

        Node temp;

        // TODO: IMP
        // pointing to first node of the list
        temp = last.next;

        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != last.next);
        System.out.println();

    }

    public int length() {
        if (last == null) {
            return 0;
        }
        int count = 0;
        Node temp;
        temp = last.next;
        do {
            temp = temp.next;
            count++;

        } while (temp != last.next);

        return count;
    }

    public void insertAtIndex(int index, int data) {
        if (index < 0 || index >= length()) {
            System.out.println("The given index is missing in the list !");
            return;
        }

        if (index == 0) {
            addBegin(data);
            return;
        }
        Node n1 = new Node(data);
        Node temp;
        temp = last.next;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        n1.next = temp.next;
        temp.next = n1;

    }

    public void removeLast() {
        if (last == null) {
            System.out.println("The list is empty !");
            return;
        }

        if (last.next == last) {
            last = null;
            return;
        }

        Node temp = last.next;
        while (temp.next != last) {
            temp = temp.next;
        }

        temp.next = last.next;
        last = temp;
    }
}
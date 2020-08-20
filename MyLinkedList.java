package dataStructures;

/**
 * MyLinkedList
 */
public class MyLinkedList<E> {

    public Node<E> head;

    public static class Node<E> {

        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
            next = null;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void pushFront(E data) {
        Node<E> n1 = new Node<E>(data);
        if (isEmpty()) {
            head = n1;
            return;
        }

        n1.next = head;
        head = n1;

    }

    public E popFront() throws Exception {
        if (isEmpty()) {
            throw new Exception("The list is already empty!");
        }
        E data2 = head.data;
        head = head.next;
        return data2;

    }

    public void print() {
        if (isEmpty()) {
            System.out.println("The list is empty !");
            return;
        }
        Node<E> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void pushBack(E data) {
        Node<E> n1 = new Node<E>(data);
        if (isEmpty()) {
            head = n1;
            return;
        }
        Node<E> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = n1;
        n1.next = null;
    }

    public E popBack() throws Exception {
        if (isEmpty()) {
            throw new Exception("The list is already empty!");
        }

        Node<E> temp = head;

        // TODO: Corner case IMP
        if (temp.next == null) {
            head = null;
            return temp.data;
        }
        // TODO: Corner case IMP

        while (temp.next.next != null) {
            temp = temp.next;
        }
        E data2 = temp.next.data;
        temp.next = null;
        return data2;
    }

    public int length() {
        if (isEmpty()) {
            return 0;
        }

        Node<E> temp = head;
        int i = 1;
        while (temp.next != null) {
            i++;
            temp = temp.next;
        }

        return i;
    }

    public void addAtIndex(int index, E data) {
        Node<E> n1 = new Node<E>(data);
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
        Node<E> temp = head;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        n1.next = temp.next;
        temp.next = n1;
    }

    public boolean find(E data) {
        if (isEmpty()) {
            return false;
        }

        Node<E> temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    public void erase(E data) {
        if (isEmpty()) {
            System.out.println("The list is empty !");
            return;
        }

        if (!find(data)) {
            System.out.println("No node with given data !");
            return;
        }

        Node<E> temp = head;
        if (temp.data == data) {
            try {
                popFront();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e);
            }
            return;
        }
        while (temp.next.data != data) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    public E getLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("The linked list is empty !");
        }
        if (head.next == null) {
            return head.data;
        }
        Node<E> temp = head;
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
        Node<E> current, prev, next;
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

    public void reverseByStack() {
        MyStack<Node<E>> stack = new MyStack<>();
        Node<E> temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        try {
            Node<E> temp2 = stack.peek();
            head = temp2;
            stack.pop();
            while (!stack.isEmpty()) {
                temp2.next = stack.peek();
                stack.pop();
                temp2 = temp2.next;
            }
            temp2.next = null;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
    // TODO: For integer LIST
    // public void Addone() {
    // String number = "";
    // Node temp = head;
    // while (temp != null) {
    // number = number + Integer.toString(temp.data);
    // temp = temp.next;
    // }
    // int n = Integer.parseInt(number);
    // String finalNumber = Integer.toString(n + 1);
    // // System.out.println(finalNumber);
    // char[] arr = finalNumber.toCharArray();
    // head = null;
    // for (char c : arr) {
    // // System.out.print(Integer.parseInt(String.valueOf(c)));
    // pushBack(Integer.parseInt(String.valueOf(c)));
    // }
    // System.out.println();
    // }

    // TODO: Driver Code
    // MyLinkedList<String> li = new MyLinkedList<>();
    // try {
    // // li.popBack();
    // li.pushFront("Satish");
    // li.pushBack("Ananda");
    // li.pushBack("Naikawadi");
    // // li.popBack();
    // li.reverse();
    // li.print();
    // } catch (Exception e) {
    // // TODO: handle exception
    // System.out.println(e);
    // }
}
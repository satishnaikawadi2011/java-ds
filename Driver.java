package dataStructures;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        CircularSinglyLinkedList cl = new CircularSinglyLinkedList();
        cl.addToEmpty(2);
        // cl.insertAtIndex(0, 1);
        // cl.insertAtIndex(1, 3);
        // cl.insertAtIndex(3, 5);
        cl.addBegin(1);
        // cl.addLast(4);
        // cl.addLast(16);
        // cl.addBegin(0);
        // cl.removeLast();
        cl.print();
        // System.out.println(cl.length());
    }
}
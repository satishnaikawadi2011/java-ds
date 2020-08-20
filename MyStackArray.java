package dataStructures;

public class MyStackArray {

    static final int MAX = 1000;

    private int top = -1;
    private int[] arr = new int[MAX];

    public void push(int data) throws Exception {
        if (top == MAX - 1) {
            throw new Exception("Stack is overflowed !");
        }
        // pre increament i.e. first increament variable and then assign;
        arr[++top] = data;
    }

    public int pop() throws Exception {
        if (top == -1) {
            throw new Exception("Stack is underflowed !");
        }
        int data = arr[top];
        top--;
        return data;
    }

    public int peek() throws Exception {
        if (top == -1) {
            throw new Exception("Cannot peek into a empty stack !");
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
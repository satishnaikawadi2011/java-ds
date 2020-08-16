package dataStructures;

public class MyStack {
    MyLinkedList li = new MyLinkedList();

    public void push(int data) {
        li.pushBack(data);
    }

    public int pop() throws Exception {
        if (li.isEmpty()) {
            throw new Exception("Popping from empty stack is not allowed");
        }

        return li.popBack();
    }

    public int peek() throws Exception {
        if (li.isEmpty()) {
            throw new Exception("peeking from empty stack is not allowed");
        }

        return li.getLast();
    }

    // TODO: driver Code
    // MyStack stack = new MyStack();
    // stack.push(2);
    // stack.push(4);
    // stack.push(6);
    // stack.push(8);
    // stack.push(10);
    // try {
    // System.out.println(stack.peek());
    // stack.pop();
    // System.out.println(stack.pop());
    // } catch (Exception e) {
    // // TODO: handle exception
    // System.out.println(e);
    // }

}
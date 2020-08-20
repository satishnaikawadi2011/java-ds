package dataStructures;

public class MyStack<E> {
    private MyLinkedList<E> li = new MyLinkedList<>();

    public void push(E data) {
        li.pushBack(data);
    }

    public E pop() throws Exception {
        if (li.isEmpty()) {
            throw new Exception("Popping from empty stack is not allowed");
        }

        return li.popBack();
    }

    public E peek() throws Exception {
        if (li.isEmpty()) {
            throw new Exception("peeking from empty stack is not allowed");
        }

        return li.getLast();
    }

    public boolean isEmpty() {
        return li.isEmpty();
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
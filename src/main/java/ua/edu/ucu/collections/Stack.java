package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList immutableLinkedList;

    public Stack() {
        immutableLinkedList = new ImmutableLinkedList();
    }


    public void push(Object e) {
        immutableLinkedList = immutableLinkedList.addLast(e);
    }

    public Object pop() {
        Object poppedElement = immutableLinkedList.getLast();
        immutableLinkedList = immutableLinkedList.removeLast();
        return poppedElement;
    }

    public Object peek() {
        return immutableLinkedList.getLast();
    }
}

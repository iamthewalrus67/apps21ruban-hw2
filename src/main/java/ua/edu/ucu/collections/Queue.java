package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import java.util.Arrays;

public class Queue {
    private ImmutableLinkedList immutableLinkedList;

    public Queue() {
        immutableLinkedList = new ImmutableLinkedList();
    }

    public Object peek() {
        if (immutableLinkedList.size() == 0) {
            return -1;
        }

        return immutableLinkedList.getFirst();
    }

    public Object dequeue() {
        Object poppedElement = immutableLinkedList.getFirst();
        immutableLinkedList = immutableLinkedList.removeFirst();
        return poppedElement;
    }

    public void enqueue(Object e) {
        immutableLinkedList = immutableLinkedList.addLast(e);
    }
}

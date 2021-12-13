package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableLinkedList implements ImmutableList {
    private final Node head;
    private final Node tail;
    private int length;

    public ImmutableLinkedList(Object[] elements) {
        head = new Node();
        Node probe = head;
        Node prevNode = null;
        for (int i = 0; i < elements.length; i++) {
            probe.setPrevious(prevNode);
            probe.setValue(elements[i]);
            if (i < elements.length-1) {
                probe.setNext(new Node());
            }
            prevNode = probe;
            if (probe.getNext() != null) {
                probe = probe.getNext();
            }
        }
        tail = probe;
        length = elements.length;
    }

    private ImmutableLinkedList(Node head, Node tail, int length) {
        this.head = head;
        this.tail = tail;
        length = length;
    }

    public ImmutableLinkedList() {
        head = new Node();
        tail = head;
        length = 0;
    }

    public void printLinkedList() {
        Node probe = head;
        for (int i = 0; i < length; i++) {
            System.out.println(probe.getValue());
            probe = probe.getNext();
        }
    }

    @Override
    public ImmutableList add(Object e) {
        return addAll(length, new Object[] {e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[] {e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object[] array = new Object[length+c.length];
        Node probe = head;

        for (int i = 0; i < index; i++) {
            array[i] = probe.getValue();
            probe = probe.getNext();
        }

        System.arraycopy(c, 0, array, index, c.length);

        for (int i = index + c.length; i < length + c.length; i++) {
            array[i] = probe.getValue();
            probe = probe.getNext();
        }
        return new ImmutableLinkedList(array);
    }

    @Override
    public Object get(int index) {
        Node probe = head;
        for (int i = 0; i < index; i++) {
            probe = probe.getNext();
        }

        return probe.getValue();
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] array = new Object[length-1];
        Node probe = head;
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (i == index) {
                probe = probe.getNext();
                continue;
            }
            array[j++] = probe.getValue();
            probe = probe.getNext();
        }

        return new ImmutableLinkedList(array);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Object[] array = new Object[length];
        Node probe = head;

        for (int i = 0; i < length; i++) {
            array[i] = (i == index) ? e : probe.getValue();
            probe = probe.getNext();
        }

        return new ImmutableLinkedList(array);
    }

    @Override
    public int indexOf(Object e) {
        Node probe = head;
        int i = 0;
        while (probe != null) {
            if (probe.getValue().equals(e)) {
                return i;
            }
            probe = probe.getNext();
            i++;
        }

        return -1;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[length];
        Node newNode = head.clone();
        Node probe = newNode;
        for (int i = 0; i < length; i++) {
            array[i] = probe.getValue();
            probe = probe.getNext();
        }

        return array;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) addAll(0, new Object[] {e});
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) add(e);
    }

    public Node getHead() {
        return head.clone();
    }

    public Node getTail() {
        Node newNode = head.clone();
        Node probe = newNode;
        while (probe.getNext() != null) {
            probe = probe.getNext();
        }

        return probe;
    }

    public Object getFirst() {
        return head.getValue();
    }

    public Object getLast() {
        return tail.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) remove(size()-1);
    }
}

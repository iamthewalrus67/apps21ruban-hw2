package ua.edu.ucu.collections.immutable;

public final class ImmutableLinkedList implements ImmutableList {
    private final Node head;
    private final Node tail;

    public ImmutableLinkedList(Object[] elements) {
        head = new Node();
        Node probe = head;
        Node prevNode = null;
        for (int i = 0; i < elements.length; i++) {
            probe.setPrevious(prevNode);
            probe.setValue(elements[i]);
            probe.setNext(new Node());
            prevNode = probe;
            probe = probe.getNext();
        }
        tail = probe;
    }

    private ImmutableLinkedList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    public ImmutableLinkedList() {
        head = new Node();
        tail = head;
    }

    public void printLinkedList() {
        Node probe = head;
        while (probe != null) {
            System.out.println(probe.getValue());
            probe = probe.getNext();
        }
    }

    @Override
    public ImmutableList add(Object e) {
        Node newNode = head.clone();
        newNode.printNode();
        Node probe = newNode;
        while (probe.getNext() != null) {
            probe = probe.getNext();
        }
        Node prevNode = probe;
        probe.setNext(new Node());
        probe = probe.getNext();
        probe.setPrevious(prevNode);

        return new ImmutableLinkedList(newNode, probe);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Node newNode = head.clone();
        Node probe = newNode;
        for (int i = 0; i < index; i++) {
            probe = probe.getNext();
        }
        Node prevNode = probe;
        Node nextNode = probe.getNext();
        probe.setNext(new Node());
        probe = probe.getNext();
        probe.setValue(e);
        probe.setPrevious(prevNode);
        probe.setNext(nextNode);

        while (probe.getNext() != null) {
            probe = probe.getNext();
        }

        return new ImmutableLinkedList(newNode, probe);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        Node newNode = head.clone();
        Node probe = newNode;
        while (probe.getNext() != null) {
            probe = probe.getNext();
        }

        for (int i = 0; i < c.length; i++) {
            Node addNode = new Node();
            addNode.setValue(c[i]);
            addNode.setPrevious(probe);
            probe.setNext(addNode);
            probe = addNode;
        }

        return new ImmutableLinkedList(newNode, probe);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Node newNode = head.clone();
        Node probe = newNode;
        for (int i = 0; i < index; i++) {
            probe = probe.getNext();
        }
        Node nextNode = probe.getNext();
        for (int i = 0; i < c.length; i++) {
            Node addNode = new Node();
            addNode.setValue(c[i]);
            addNode.setPrevious(probe);
            probe.setNext(addNode);
            probe = addNode;
        }

        probe.setNext(nextNode);
        return new ImmutableLinkedList(newNode, probe);
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
        Node newNode = head.clone();
        Node probe = newNode;
        for (int i = 0; i < index; i++) {
            probe = probe.getNext();
        }

        probe.setNext(probe.getNext().getNext());

        while (probe.getValue() != null) {
            probe = probe.getNext();
        }

        return new ImmutableLinkedList(newNode, probe);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Node newNode = head.clone();
        Node probe = newNode;
        for (int i = 0; i < index+1; i++) {
            probe = probe.getNext();
        }
        probe.setValue(e);
        while (probe.getNext() != null) {
            probe = probe.getNext();
        }

        return new ImmutableLinkedList(newNode, probe);
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
        int i = 0;
        Node probe = head;
        while (probe != null) {
            probe = probe.getNext();
            i++;
        }

        return i;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Object[] toArray() {
        int size = size();
        Object[] array = new Object[size];
        Node newNode = head.clone();
        Node probe = newNode;
        for (int i = 0; i < size; i++) {
            array[i] = probe.getValue();
            probe = probe.getNext();
        }

        return array;
    }

    public ImmutableLinkedList addFirst(Object e) {
        Node newNode = head.clone();
        Node probe = newNode;
        while (probe.getNext() != null) {
            probe = probe.getNext();
        }
        Node nextNode = newNode;
        nextNode.setPrevious(newNode);
        newNode.setPrevious(new Node());
        newNode = newNode.getPrevious();
        newNode.setNext(nextNode);
        return new ImmutableLinkedList(newNode, probe);
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

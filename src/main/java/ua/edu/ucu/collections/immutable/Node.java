package ua.edu.ucu.collections.immutable;

public class Node {
    private Node previous;
    private Node next;
    private Object value;

    public Node() {
    }

    public Node(Node nd) {
        previous = nd.previous;
        value = nd.value;
        next = nd.next;
    }

    public Node(Object val) {
        value = val;
    }

    @Override
    public String toString() {
        return value.toString();
    }


    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node prev) {
        previous = prev;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object val) {
        value = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node ne) {
        next = ne;
    }

    protected Node clone() {
        Node newNode = new Node(value);
        Node prevNode = newNode;
        Node probe = next;
        while (probe != null) {
            Node nextNode = new Node(probe.getValue());
            nextNode.previous = prevNode;
            prevNode.next = nextNode;
            prevNode = nextNode;
            probe = probe.getNext();
        }
//        if (newNode.next != null) {
//            Node probe = new Node(newNode.next);
//            newNode.next = probe;
//            Node prevNode = newNode;
//            while (probe != null) {
//                probe = new Node(probe);
//                probe.previous = prevNode;
//                prevNode = probe;
//                probe = probe.next;
//            }
//        }

        return newNode;
    }

    public void printNode() {
        Node probe = this;
        while (probe != null) {
            System.out.println(probe.getValue());
            probe = probe.getNext();
        }
    }
}


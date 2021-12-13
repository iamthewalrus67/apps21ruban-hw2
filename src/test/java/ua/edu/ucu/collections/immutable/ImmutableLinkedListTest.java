package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    ImmutableLinkedList immutableLinkedList;

    @Before
    public void setUp() {
        immutableLinkedList = new ImmutableLinkedList(new Integer[] {Integer.valueOf(1), Integer.valueOf(2)});
    }

    @Test
    public void testAdd() {
        immutableLinkedList = (ImmutableLinkedList) immutableLinkedList.add(Integer.valueOf(3));
        assertArrayEquals(new Integer[] {Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)}, immutableLinkedList.toArray());
    }


    @Test
    public void testAddAll() {
        immutableLinkedList = (ImmutableLinkedList) immutableLinkedList.addAll(new Integer[] {Integer.valueOf(3), Integer.valueOf(4)});
        assertArrayEquals(new Integer[] {Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4)}, immutableLinkedList.toArray());
    }

    @Test
    public void testGet() {
        assertEquals(Integer.valueOf(2), immutableLinkedList.get(1));
    }

    @Test
    public void testRemove() {
        immutableLinkedList = (ImmutableLinkedList) immutableLinkedList.remove(1);
        assertArrayEquals(new Integer[] {Integer.valueOf(1)}, immutableLinkedList.toArray());
    }

    @Test
    public void testSet() {
        immutableLinkedList = (ImmutableLinkedList) immutableLinkedList.set(1, Integer.valueOf(3));
        assertArrayEquals(new Integer[] {Integer.valueOf(1), Integer.valueOf(3)}, immutableLinkedList.toArray());
    }

    @Test
    public void testIndexOf() {
        assertEquals(1, immutableLinkedList.indexOf(Integer.valueOf(2)));
    }

    @Test
    public void testSize() {
        assertEquals(2, immutableLinkedList.size());
    }

    @Test
    public void testClear() {
        immutableLinkedList = (ImmutableLinkedList) immutableLinkedList.clear();
        assertArrayEquals(new Integer[]{}, immutableLinkedList.toArray());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(immutableLinkedList.clear().isEmpty());
    }

    @Test
    public void testToArray() {
        assertArrayEquals(new Integer[] {Integer.valueOf(1), Integer.valueOf(2)}, immutableLinkedList.toArray());
    }

    @Test
    public void testAddFirst() {
        assertArrayEquals(new Integer[] {Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2)}, immutableLinkedList.addFirst(Integer.valueOf(3)).toArray());

    }

    @Test
    public void testAddLast() {
        assertArrayEquals(new Integer[] {Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)}, immutableLinkedList.addLast(Integer.valueOf(3)).toArray());
    }

    @Test
    public void testGetHead() {
        assertEquals(1, immutableLinkedList.getHead().getValue());
    }

    @Test
    public void testGetTail() {
        assertEquals(2, immutableLinkedList.getTail().getValue());
    }

    @Test
    public void testGetFirst() {
        assertEquals(1, immutableLinkedList.getFirst());
    }

    @Test
    public void testGetLast() {
        assertEquals(2, immutableLinkedList.getLast());
    }

    @Test
    public void testRemoveFirst() {
        assertArrayEquals(new Integer[] {Integer.valueOf(2)}, immutableLinkedList.removeFirst().toArray());
    }

    @Test
    public void testRemoveLast() {
        assertArrayEquals(new Integer[] {Integer.valueOf(1)}, immutableLinkedList.removeLast().toArray());
    }
}
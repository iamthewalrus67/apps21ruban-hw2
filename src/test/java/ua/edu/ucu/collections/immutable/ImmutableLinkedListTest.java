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
//        immutableLinkedList.printLinkedList();
//        System.out.println(Arrays.toString(immutableLinkedList.toArray()));
        assertArrayEquals(new Integer[] {Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)}, immutableLinkedList.toArray());
    }


    @Test
    public void testAddAll() {
    }

    @Test
    public void testTestAddAll() {
    }

    @Test
    public void testGet() {
    }

    @Test
    public void testRemove() {
    }

    @Test
    public void testSet() {
    }

    @Test
    public void testIndexOf() {
    }

    @Test
    public void testSize() {
    }

    @Test
    public void testClear() {
    }

    @Test
    public void testIsEmpty() {
    }

    @Test
    public void testToArray() {
    }

    @Test
    public void testAddFirst() {
    }

    @Test
    public void testAddLast() {
    }

    @Test
    public void testGetHead() {
    }

    @Test
    public void testGetTail() {
    }

    @Test
    public void testGetFirst() {
    }

    @Test
    public void testGetLast() {
    }

    @Test
    public void testRemoveFirst() {
    }

    @Test
    public void testRemoveLast() {
    }
}
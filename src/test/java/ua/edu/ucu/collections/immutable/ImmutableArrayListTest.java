package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    ImmutableArrayList immutableArrayList;

    @Before
    public void setUp() {
        immutableArrayList = new ImmutableArrayList(new Integer[] {Integer.valueOf(1), Integer.valueOf(2)});

    }

    @Test
    public void testAdd() {
        immutableArrayList = (ImmutableArrayList) immutableArrayList.add(Integer.valueOf(3));
        assertArrayEquals(new Integer[] {Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)}, immutableArrayList.toArray());
        immutableArrayList = new ImmutableArrayList(new Integer[] {Integer.valueOf(1), Integer.valueOf(2)});
        immutableArrayList = (ImmutableArrayList) immutableArrayList.add(1, Integer.valueOf(3));
        assertArrayEquals(new Integer[] {Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(2)}, immutableArrayList.toArray());
    }

    @Test
    public void testAddAll() {
        immutableArrayList = (ImmutableArrayList) immutableArrayList.addAll(new Integer[] {Integer.valueOf(3), Integer.valueOf(4)});
        assertArrayEquals(new Integer[] {Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4)}, immutableArrayList.toArray());

        immutableArrayList = new ImmutableArrayList(new Integer[] {Integer.valueOf(1), Integer.valueOf(2)});
        immutableArrayList = (ImmutableArrayList) immutableArrayList.addAll(1, new Integer[]{Integer.valueOf(3), Integer.valueOf(4)});
        assertArrayEquals(new Integer[] {Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(2)}, immutableArrayList.toArray());
    }

    @Test
    public void testGet() {
        assertEquals(Integer.valueOf(2), immutableArrayList.get(1));
    }

    @Test
    public void testRemove() {
        assertArrayEquals(new Integer[] {Integer.valueOf(1)}, immutableArrayList.remove(1).toArray());
    }

    @Test
    public void testSet() {
        assertArrayEquals(new Integer[] {Integer.valueOf(1), Integer.valueOf(5)}, immutableArrayList.set(1, 5).toArray());
    }

    @Test
    public void testIndexOf() {
        assertEquals(1, immutableArrayList.indexOf(Integer.valueOf(2)));
    }

    @Test
    public void testSize() {
        assertEquals(2, immutableArrayList.size());
    }

    @Test
    public void testClear() {
        assertArrayEquals(new Integer[0], immutableArrayList.clear().toArray());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(immutableArrayList.isEmpty());
        assertTrue(immutableArrayList.clear().isEmpty());
    }

    @Test
    public void testToArray() {
        assertArrayEquals(new Integer[] {Integer.valueOf(1), Integer.valueOf(2)}, immutableArrayList.toArray());
    }
}
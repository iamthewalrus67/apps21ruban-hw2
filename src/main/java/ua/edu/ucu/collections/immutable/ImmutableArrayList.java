package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.Objects;

public final class ImmutableArrayList implements ImmutableList {
    private final Object[] array;

    public ImmutableArrayList(Object[] elements) {
        array = elements.clone();
    }

    public ImmutableArrayList() {
        array = new Object[0];
    }

    @Override
    public ImmutableList add(Object e) {
        Object[] newArray = Arrays.copyOf(array, array.length+1);
        newArray[newArray.length-1] = e;

        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object[] newArray = Arrays.copyOf(array, array.length+1);
        for (int i = newArray.length-1; i > index; i--) {
            newArray[i] = newArray[i-1];
        }
        newArray[index] = e;

        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        Object[] newArray = Arrays.copyOf(array, array.length+c.length);

        System.arraycopy(c, 0, newArray, array.length, c.length);

        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object[] newArray = new Object[array.length+c.length];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(c, 0, newArray, index, c.length);
        System.arraycopy(array, index, newArray, index+c.length, array.length-index);
        return new ImmutableArrayList(newArray);
    }

    @Override
    public Object get(int index) {
        return array[index];
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] newArray = new Object[array.length-1];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == index) {
                continue;
            }
            newArray[j] = array[i];
            j++;
        }

        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Object[] newArray = Arrays.copyOf(array, array.length);
        newArray[index] = e;

        return new ImmutableArrayList(newArray);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = Arrays.copyOf(array, array.length);
        return newArray;
    }
}

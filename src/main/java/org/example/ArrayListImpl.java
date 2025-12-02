package org.example;

public class ArrayListImpl<T> {
    private Object[] array;
    private int lastIndex;

    public ArrayListImpl(int size) {
        this.array = new Object[size];
        this.lastIndex = 0;
    }

    public void add(T value) {
        if (this.lastIndex >= array.length) {
            Object[] largerArray = new Object[this.array.length * 2];
            for (int i = 0; i < this.array.length; i++) {
                largerArray[i] = this.array[i];
            }
            this.array = largerArray;
        }
        this.array[this.lastIndex++] = value;
    }

    public Object get(int index) {
        return this.array[index];
    }

    public void remove(int index) {
        if (index == this.lastIndex) {
            this.array[this.lastIndex--] = null;
        } else if (index < this.lastIndex) {
            this.array[index] = null;
        }
    }
}

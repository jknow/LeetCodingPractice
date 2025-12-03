package org.example;

public class StackImpl<E> {
    private Object[] array;
    private int topPointer;
    private int size;

    public StackImpl(int size) {
        this.array = new Object[size];
        this.topPointer = 0;
        this.size = 0;
    }

    public void push(E element) {
        this.array[this.topPointer++] = element;
        this.size++;
        if (this.size == this.array.length) {
            this.resize();
        }
    }

    public E pop() {
        if (this.topPointer == 0) {
            return null;
        }
        E element = (E) this.array[--this.topPointer];
        this.size--;
        return element;
    }

    private void resize() {
        Object[] largerArray = new Object[this.array.length * 2];
        for (int i = 0; i < this.size; i++) {
            largerArray[i] = this.array[i];
        }
        this.array = largerArray;
        this.topPointer = this.size;
    }
}

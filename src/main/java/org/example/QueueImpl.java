package org.example;

public class QueueImpl<E> {
    private Object[] array;
    private int frontPointer;
    private int backPointer;
    private int size;

    public QueueImpl(int size) {
        this.array = new Object[size];
        this.frontPointer = 0;
        this.backPointer = 0;
        this.size = 0;
    }

    public void enqueue(E element) {
        if (this.array[this.backPointer] == null) {
            this.array[this.backPointer] = element;
            this.size++;
            if (this.size == this.array.length) {
                this.resize();
            } else {
                this.backPointer = (this.backPointer + 1) % this.array.length;
            }
        } else {
            this.resize();
        }
    }

    public E dequeue() {
        E element = (E) this.array[this.frontPointer];
        if (element == null) {
            return null;
        }
        this.array[this.frontPointer] = null;
        this.frontPointer = (this.frontPointer + 1) % this.array.length;
        this.size--;
        if (this.size == 0) {
            this.frontPointer = 0;
            this.backPointer = 0;
        }
        return element;
    }

    private void resize() {
        Object[] largerArray = new Object[this.array.length * 2];
        for (int i = 0; i < this.size; i++) {
            largerArray[i] = this.array[(this.frontPointer + i) % this.array.length];
        }
        this.array = largerArray;
        this.frontPointer = 0;
        this.backPointer = this.size;
    }
}

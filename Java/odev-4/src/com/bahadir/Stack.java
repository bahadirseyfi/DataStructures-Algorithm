package com.bahadir;

public class Stack<T> {
    private static int max  = 50;

    private Element<T> top;
    private int size = 0;


    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull(){
        return size == max;
    }
    public int getSize() {
        return size;
    }

    // Push: Stack’e yeni bir veri eklememize yarar.

    public void push(T data) throws StackOverflowError {
        if (size == max){
            throw  new StackOverflowError();
        }
        Element element = new Element(data, top);
        top = element;
        size += 1;
    }

    // Pop: Stack’in tepesindeki yani son giren elemanı silip geri dönderir.

    public T pop() throws StackOverflowError {
        if (size == 0){
            throw new StackOverflowError();
        }
        T data = top.getData();
        top = top.getNext();

        size -= 1;
        return data;
    }

    // Peek: Stack’in tepesindeki veriyi silmeden geri dönderir.

    public T peek() throws StackOverflowError {
        if (size == 0){
            throw new StackOverflowError();
        }
        return top.getData();
    }
}

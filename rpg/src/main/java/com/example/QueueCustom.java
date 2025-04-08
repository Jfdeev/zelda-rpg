package com.example;
class QueueCustom<T> {
    private Node<T> front, rear;
    public boolean isEmpty() { return front == null; }
    public void enqueue(T item) {
        Node<T> node = new Node<>(item);
        if (rear != null) rear.next = node;
        rear = node;
        if (front == null) front = rear;
    }
    public T dequeue() {
        if (isEmpty()) return null;
        T data = front.data;
        front = front.next;
        if (front == null) rear = null;
        return data;
    }
}
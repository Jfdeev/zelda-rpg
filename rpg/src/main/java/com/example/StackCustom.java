package com.example;
import java.util.List;
import java.util.ArrayList;

class StackCustom<T> {
    private Node<T> top;
    public boolean isEmpty() { return top == null; }
    public void push(T item) {
        Node<T> node = new Node<>(item);
        node.next = top;
        top = node;
    }
    public T pop() {
        if (isEmpty()) return null;
        T data = top.data;
        top = top.next;
        return data;
    }
    public List<T> toList() {
        List<T> list = new ArrayList<>();
        Node<T> curr = top;
        while (curr != null) { list.add(curr.data); curr = curr.next; }
        return list;
    }
}

package com.example;
import java.util.ArrayList;
import java.util.List;


class LinkedListCustom<T> {
    private Node<T> head;
    public void add(T item) {
        if (head == null) head = new Node<>(item);
        else {
            Node<T> curr = head;
            while (curr.next != null) curr = curr.next;
            curr.next = new Node<>(item);
        }
    }
    public List<T> toList() {
        List<T> list = new ArrayList<>();
        Node<T> curr = head;
        while (curr != null) { list.add(curr.data); curr = curr.next; }
        return list;
    }
}

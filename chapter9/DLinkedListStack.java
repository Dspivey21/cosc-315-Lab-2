package chapter9;

import my.util.DLinkedList;

public class DLinkedListStack<T> implements Stack<T> {

    private final DLinkedList<T> list;

    public DLinkedListStack() {
        list = new DLinkedList<>();
    }

    @Override
    public void push(T item) {
        list.add(item);
    }

    @Override
    public T pop() throws Exception {
        if (list.isEmpty()) throw new Exception("Stack is empty");
        return list.removeLast().getData();
    }

    @Override
    public T top() throws Exception {
        if (list.isEmpty()) throw new Exception("Stack is empty");
        return list.get(list.size() - 1).getData();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}

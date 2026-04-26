package chapter9;

import java.util.ArrayList;

public class SortedArrayListPriorityQueue<T> implements PriorityQueue<T> {

    private static class Entry<T> implements Comparable<Entry<T>> {
        final int priority;
        final T data;
        Entry(int priority, T data) {
            this.priority = priority;
            this.data = data;
        }

        @Override
        public int compareTo(Entry<T> o) {
            return this.priority - o.priority;
        }
    }

    private final ArrayList<Entry<T>> list;

    public SortedArrayListPriorityQueue() {
        list = new ArrayList<>();
    }

    @Override
    public void enqueue(int priority, T data) {
        // Keep list sorted ASC by priority (front = lowest number = highest priority).
        // For equal priorities, new entry is placed AFTER existing equal entries (stable FIFO).
        Entry<T> entry = new Entry<>(priority, data);
        int n = list.size();
        int i = 0;
        while (i < n && list.get(i).priority <= priority) {
            i++;
        }
        list.add(i, entry);
    }

    @Override
    public T dequeue() throws Exception {
        if (list.isEmpty()) throw new Exception("PriorityQueue is empty");
        return list.remove(0).data;
    }

    @Override
    public T front() throws Exception {
        if (list.isEmpty()) throw new Exception("PriorityQueue is empty");
        return list.get(0).data;
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

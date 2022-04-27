package dataStructure;

import java.util.ArrayList;
public class MyQueue<T> {
    private final ArrayList<T> item = new ArrayList<>();

    public void enqueue(T data) {
        item.add(data);
    }

    public T dequeue() {
        if(item.size()==0) {
            return null;
        }
        return item.remove(0);
    }

    public boolean isEmpty() {
        return item.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue item = new MyQueue<>();
        item.enqueue(1);
        item.enqueue(2);
        item.enqueue(3);
        System.out.println(item.dequeue());
        System.out.println(item.dequeue());
        System.out.println(item.dequeue());
        System.out.println(item.dequeue());
        System.out.println(item.isEmpty());
    }

}

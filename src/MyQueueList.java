import java.util.*;

public class MyQueueList<T> {
    private static class Node<T> {
        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;

    public boolean isEmpty() {
        return head == null;
    }


    public T peek() {
        return head.data;
    }

    public void add(T data) {
        Node addtion = new Node(data);
        if (head == null) {
            head = addtion;
            tail = addtion;

        } else {
            tail.next = addtion;
            tail = addtion;
        }
    }

    public T remove () {
       Node<T> current = head;
       head = current.next;
       if (head == null){
           tail = null;
       }
       return current.data;
    }

    public static void main(String[] args) {
        ArrayList<String> Tests = new ArrayList<String>();
        for (String string : args) {
            Tests.add(string);
        }
        Tests.add("a");
        Tests.add("b");
        Tests.add("c");
        Tests.add("d");
        Tests.add("e");

        Tests.add("f");

        MyQueueList<String> stringQueue = new MyQueueList<>();

        for (String test : Tests) {
            stringQueue.add(test);
        }

        while (!stringQueue.isEmpty()) {
            System.out.print(stringQueue.remove() + ", ");

        }

        MyQueueList<Integer> intQueue = new MyQueueList<>();
        System.out.print("\n");
        intQueue.add(1);
        intQueue.add(2);
        System.out.print(intQueue.remove() + ", ");
        intQueue.add(3);
        intQueue.add(4);
        System.out.print(intQueue.remove() + ", ");
        intQueue.add(5);
        intQueue.add(6);
        System.out.print(intQueue.remove() + ", ");


    }
}

import java.util.*;
public class MyStackList<T> {
    private static class Node<T> {
        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
        }
    }

    private Node<T> top;

    public boolean isEmpty() {
        return top == null;
    }

    public T peek() {
        return top.data;
    }

    public void push(T data) {
        Node addtion = new Node(data);
        if (top == null){
            top = addtion;
        } else {
            addtion.next = top;;
            top = addtion;
        }

    }

    public T pop() {
        Node<T> current = top;
        top = current.next;
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

        MyStackList<String> stringQueue = new MyStackList<>();

        for (String test : Tests) {
            stringQueue.push(test);
        }

        while (!stringQueue.isEmpty()) {
            System.out.print(stringQueue.pop() + ", ");

        }

        MyStackList<Integer> intQueue = new MyStackList<>();
        System.out.print("\n");
        intQueue.push(1);
        intQueue.push(2);
        System.out.print(intQueue.pop() + ", ");
        intQueue.push(3);
        intQueue.push(4);
        System.out.print(intQueue.pop() + ", ");
        intQueue.push(5);
        intQueue.push(6);
        System.out.print(intQueue.pop() + ", ");


    }
}
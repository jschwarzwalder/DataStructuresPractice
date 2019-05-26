

public class LinkedList<T>{
    private class Node<T> {
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

    public void addAtEnd(T data) {
        Node addtion = new Node(data);
        if (head == null) {
            head = addtion;
            tail = addtion;

        } else {
            tail.next = addtion;
            tail = addtion;
        }
    }

    public void append(T data){
        Node addtion = new Node(data);
        if (head == null) {
            head = addtion;
        } else {
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = addtion;
        }
    }

    public void prepend(T data){
        Node addtion = new Node(data);
        if (head != null) {
            addtion.next = head;
        }
            head = addtion;
    }

    public void deleteWithValue(T data){
        if (head == null) return;
        Node current = head;
        Node prev = null;
        while (current.next != null){
            if (current.next.data == data){
                if (prev == null){
                    head = current.next;
                }
                else {
                    prev.next = current.next;
                }
            }
            prev = current;
            current = current.next;
        }


    }

    public void simpleDeleteWithValue(T data){
        if (head == null) return;
        if (head.data == data){
            head = head.next;
        }
        Node current = head;

        while (current.next != null){
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }


    }

    public Node<T> getHead(){
        return head;
    }


}



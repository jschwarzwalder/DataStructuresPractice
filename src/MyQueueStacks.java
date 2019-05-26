import java.util.Stack;
import java.util.*;

public class MyQueueStacks<T> {
    private Stack<T> stackNewestOnTop = new Stack<T>();
    private Stack<T> stackOldestOnTop = new Stack<T>();

    public void enque(T Value) { //Add item
        stackNewestOnTop.push(Value);
    }

    public T peak() { //Get "oldest" item
        //move elements from stackNewest to stackOldest

        moveToOldest();

        if (!stackOldestOnTop.empty())
            return stackOldestOnTop.peek();
        else {
            return null;
        }

    }

    public T dequeue() { //Get "oldest" item and remove it
        //move elements from stackNewest to stackOldest

        moveToOldest();

        return stackOldestOnTop.pop();


    }

    private void moveToOldest() {
        if (stackOldestOnTop.isEmpty()) {
            while (!stackNewestOnTop.isEmpty()) {
                stackOldestOnTop.push(stackNewestOnTop.pop());
            }
        }
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

        MyQueueStacks<String> stringQueue = new MyQueueStacks<>();

        for (String test : Tests) {
            stringQueue.enque(test);
        }

        while (stringQueue.peak() != null) {
            System.out.print(stringQueue.dequeue() + ", ");

        }

        MyQueueStacks<Integer> intQueue = new MyQueueStacks<>();
        System.out.print("\n");
        intQueue.enque(1);
        intQueue.enque(2);
        System.out.print(intQueue.dequeue() + ", ");
        intQueue.enque(3);
        intQueue.enque(4);
        System.out.print(intQueue.dequeue() + ", ");
        intQueue.enque(5);
        intQueue.enque(6);
        System.out.print(intQueue.dequeue() + ", ");


    }
}

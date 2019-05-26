public class LinkedListCycle {
    private static class Node<T> {
        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
        }
    }

    public static class LinkedList<T>{
        private Node<T> head;
        private Node<T> tail;

        public boolean isEmpty() {
            return head == null;
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

       public Node<T> getHead(){
            return head;
        }


    }

    public static boolean hasCycle(Node head) {
       boolean loops = false;
        Node singleAdvance;
        Node doubleAdvance;
        if (head == null){
            return loops;
        } else {
            singleAdvance = head;
        }

        if (head.next == null){
            return loops;
        } else {
            doubleAdvance = head.next;
        }

        while(doubleAdvance != null && singleAdvance != null){
            if (singleAdvance == doubleAdvance){
                return true;
            }

            doubleAdvance = doubleAdvance.next;
            if (doubleAdvance != null) {
                doubleAdvance = doubleAdvance.next;
                singleAdvance = singleAdvance.next;

            }

        }

        return loops;



    }

    public  static boolean simpleHasCycle(Node head){
        if (head == null) return false;
        Node fast = head.next;
        Node slow = head;

        while (fast != null && fast.next != null && slow != null){
            if (fast == slow){
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return  false;
    }

    public static void main(String[] args) {
       LinkedList<Node<Integer>> intList =  new LinkedList<>();
       Node<Integer> headNode = new Node<Integer>(-1);
       intList.add(headNode);
       Node<Integer> lastNode = headNode;
       for (int i = 0; i < 25; i++){
           Node<Integer> addition = new Node<Integer>(i);
           intList.add(addition);
           lastNode.next = addition;
           lastNode = addition;
       }
       lastNode.next = headNode;

       System.out.println("Linked list is cyclical: " + hasCycle(headNode));
       System.out.println("Linked list is cyclical: " + simpleHasCycle(headNode));


        Node<String> headStringNode = new Node<String>("a");
        Node<String> middleNode = new Node<>("b");
        headStringNode.next = middleNode;
        Node<String> lastStringNode = new Node<>("c");
        middleNode.next = lastStringNode;
        lastStringNode.next = headStringNode;

        System.out.println(headStringNode.data);
        System.out.println(headStringNode.next.data);
        System.out.println(headStringNode.next.next.data);
        System.out.println(headStringNode.next.next.next.data);
        System.out.println("String list is cyclical: " + hasCycle(headStringNode));
        System.out.println("String list is cyclical: " + simpleHasCycle(headStringNode));
    }
}

import java.util.List;

import static com.sun.javafx.fxml.expression.Expression.add;

public class LIstNode {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode root;

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode root;
            ListNode nextl1 = l1.next;
            ListNode nextl2 = l2.next;
            int value = l1.val + l2.val;
            if (value > 9) {
                root = new ListNode(1);
                value = value % 10;
                root = add(value, root);
            } else {
                root = new ListNode(value);
            }
            while (nextl2 != null && nextl1 != null) {
                value = nextl1.val + nextl2.val;
                if (value > 9) {
                    root.val += 1;
                    value = value % 10;
                }
                root = add(value, root);
                nextl1 = nextl1.next;
                nextl2 = nextl2.next;

            }
            return root;


        }

        public ListNode add(int value, ListNode node){
            ListNode newNode = new ListNode(value);
            newNode.next = node;
            return newNode;

        }
    }
}

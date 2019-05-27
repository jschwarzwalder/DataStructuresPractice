public class BalancedTree<T extends Comparable<T>> {
    private class Node<T extends Comparable<T>> {
        private T data;
        private int height;
        private Node<T> left;
        private Node<T> right;

        private Node(T data) {
            this.data = data;
        }
    }


    private Node<T> root;
    private int treeHeight;

    public void insert(T data) {
        if (root == null) {
            root = new Node<T>(data);
            root.height = 1;
            treeHeight = 1;
        } else {
            insert(data, root);
        }
    }

    public void insert(T data, Node<T> node) {
        if (!contains(data)) {

        }


        if (data.compareTo(node.data) < 0) {
            if (Math.abs(node.right.height - node.left.height) < 2) {
                if (node.right != null) {
                    insert(data, node.right);
                } else {
                    node.right = new Node<T>(data);
                }
            } else {
                if (node.left != null) {
                    insert(data, node.left);
                } else {
                    node.left = new Node<T>(data);
                }
            }
        }


    }

    public boolean contains(T data) {
        Node<T> current = root;
        while (current != null) {
            if (data.compareTo(current.data) == 0) {
                return true;
            } else if (data.compareTo(current.data) > 0) {
                current = current.right;

            } else {
                current = current.left;
            }
        }
        return false;
    }

    public void printInOrder() {
        printInOrder(root);
    }

    public void printInOrder(Node<T> head) {
        Node<T> current = head;
        if (current != null) {
            if (current.left != null) {
                printInOrder(current.left);
            }
            System.out.print(current.data);
            System.out.print(", ");
            if (current.right != null) {
                printInOrder(current.right);

            }
        }
    }

    public void printPreOrder() {
        printPreOrder(root);
    }

    public void printPreOrder(Node<T> head) {
        Node<T> current = head;
        if (current != null) {
            System.out.print(current.data);
            System.out.print(", ");
            if (current.left != null) {
                printInOrder(current.left);
            }

            if (current.right != null) {
                printInOrder(current.right);

            }
        }


    }

    public void printPostOrder() {
        printPostOrder(root);
    }

    public void printPostOrder(Node<T> head) {
        Node<T> current = head;
        if (current != null) {

            if (current.left != null) {
                printInOrder(current.left);
            }

            if (current.right != null) {
                printInOrder(current.right);

            }
            System.out.print(current.data);
            System.out.print(", ");

        }
    }

    public static void main(String[] args) {
        BalancedTree<Integer> tree = new BalancedTree<>();

        for (int i = 1; i <= 10; i++) {
            tree.insert(i);
        }

        tree.printPreOrder();
        System.out.println();
        tree.printInOrder();
        System.out.println();
        tree.printPostOrder();
        System.out.println();

        System.out.println(tree.contains(5));

        BalancedTree<Integer> tree2 = new BalancedTree<>();

        for (int i = 10; i > 0; i--) {
            tree2.insert(i);
        }

        tree2.printPreOrder();
        System.out.println();
        tree2.printInOrder();
        System.out.println();
        tree2.printPostOrder();
        System.out.println();

        BalancedTree<Integer> tree3 = new BalancedTree<>();

        tree3.insert(5);
        tree3.insert(4);
        tree3.insert(3);
        tree3.insert(2);
        tree3.insert(1);
        tree3.insert(10);
        tree3.insert(11);
        tree3.insert(12);
        tree3.insert(13);
        tree3.insert(14);
        tree3.insert(15);
        tree3.insert(6);
        tree3.insert(8);
        tree3.insert(7);
        tree3.insert(9);

        tree3.printPreOrder();
        System.out.println();
        tree3.printInOrder();
        System.out.println();
        tree3.printPostOrder();
        System.out.println();

    }
}




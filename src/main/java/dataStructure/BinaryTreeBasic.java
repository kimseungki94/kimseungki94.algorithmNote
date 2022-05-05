package dataStructure;

public class BinaryTreeBasic {
    Node head;

    public class Node {
        Node left;
        Node right;
        Integer value;

        public Node(Integer value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public boolean addNode(Integer value) {
        if (this.head == null) {
            this.head = new Node(value);
        } else {
            Node node = this.head;
            while (true) {
                if (node.value > value) {
                    if (node.left != null) {
                        node = node.left;
                    } else {
                        node.left = new Node(value);
                        break;
                    }
                } else {
                    if (node.right != null) {
                        node = node.right;
                    } else {
                        node.right = new Node(value);
                        break;
                    }
                }
            }
        }
        return true;
    }

    public Node search(Integer data) {
        Node node = this.head;
        if (node == null) {
            return null;
        } else {
            while (node != null) {
                if (node.value == data) {
                    return node;
                } else if (node.value > data) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
        }
        return null;
    }
    //메인
    public static void main(String[] args) {
        BinaryTreeBasic tree = new BinaryTreeBasic();
        tree.addNode(1);
        tree.addNode(2);
        tree.addNode(3);

        System.out.println(tree.search(2).value);
        System.out.println(tree.search(1).right.right.value);
    }
}

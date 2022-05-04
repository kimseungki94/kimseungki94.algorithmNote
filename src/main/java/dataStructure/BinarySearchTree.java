package dataStructure;

public class BinarySearchTree {
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

    public boolean delete(int value) {
        Node node = this.head;
        Node parentNode = this.head;
        boolean find = false;
        if (node == null) {
            return false;
        } else {
            if (node.left == null && node.right == null && node.value == value) {
                this.head = null;
                return true;
            } else {
                while (node != null) {
                    if (node.value == value) {
                        find = true;
                        break;
                    } else if (node.value > value) {
                        parentNode = node;
                        node = node.left;
                    } else {
                        parentNode = node;
                        node = node.right;
                    }
                }
            }
        }
        if (!find) {
            return false;
        } else {
            if (node.left == null && node.right == null) {
                if (parentNode.left.value > node.left.value) {
                    parentNode.left = null;
                    node = null;
                } else {
                    parentNode.right = null;
                    node = null;
                }
                return true;
            } else if (node.left != null && node.right == null) {
                if (parentNode.value > value) {
                    parentNode.left = node.left;
                    node = null;
                } else {
                    parentNode.right = node.left;
                    node = null;
                }
                return true;
            } else if (node.left == null && node.right != null) {
                if (parentNode.value > value) {
                    parentNode.left = node.right;
                    node = null;
                } else {
                    parentNode.right = node.right;
                    node = null;
                }
                return true;
            }
        }
        return false;
    }
}

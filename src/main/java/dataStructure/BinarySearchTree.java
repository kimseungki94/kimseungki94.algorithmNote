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

    public boolean insertNode(Integer value) {
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
            } else {
                if (parentNode.value > node.value) {
                    Node changeParentNode = node.right;
                    Node changeNode = node.right;
                    while (changeNode.left != null) {
                        changeParentNode = changeNode;
                        changeNode = changeNode.left;
                    }
                    if (changeNode.right != null) {
                        changeParentNode.left = changeNode.right;
                    } else {
                        changeParentNode.left = null;
                    }
                    parentNode.left = changeNode;
                    changeNode.left = node.left;
                    changeNode.right = node.right;

                    node = null;
                } else {
                    Node changeParentNode = node.right;
                    Node changeNode = node.right;
                    while (changeNode.left != null) {
                        changeParentNode = changeNode;
                        changeNode = changeNode.left;
                    }
                    if (changeNode.right != null) {
                        changeParentNode.left = changeNode.right;
                    } else {
                        changeParentNode.left = null;
                    }
                    parentNode.right = changeNode;
                    changeNode.left = node.left;
                    changeNode.right = node.right;

                    node = null;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BinarySearchTree myTree = new BinarySearchTree();
        myTree.insertNode(10);
        myTree.insertNode(15);
        myTree.insertNode(13);
        myTree.insertNode(11);
        myTree.insertNode(14);
        myTree.insertNode(18);
        myTree.insertNode(16);
        myTree.insertNode(19);
        myTree.insertNode(17);
        myTree.insertNode(7);
        myTree.insertNode(8);
        myTree.insertNode(6);
        System.out.println(myTree.delete(15));
        System.out.println("HEAD: " + myTree.head.value);
        System.out.println("HEAD LEFT: " + myTree.head.left.value);
        System.out.println("HEAD LEFT LEFT: " + myTree.head.left.left.value);
        System.out.println("HEAD LEFT RIGHT: " + myTree.head.left.right.value);

        System.out.println("HEAD RIGHT: " + myTree.head.right.value);
        System.out.println("HEAD RIGHT LEFT: " + myTree.head.right.left.value);
        System.out.println("HEAD RIGHT RIGHT: " + myTree.head.right.right.value);

        System.out.println("HEAD RIGHT RIGHT LEFT: " + myTree.head.right.right.left.value);
        System.out.println("HEAD RIGHT RIGHT RIGHT: " + myTree.head.right.right.right.value);
    }
}

package dataStructure;

public class BinarySearchTreeTest {
    Node head = null;

    public class Node {
        Node left;
        Node right;
        Integer value;

        public Node(Integer value) {
            this.left = null;
            this.right = null;
            this.value = value;
        }
    }

    public boolean insertNode(Integer value) {
        if (this.head == null) {
            this.head = new Node(value);
            return true;
        } else {
            Node parentNode = this.head;
            Node currentNode = this.head;
            while (currentNode != null) {
                if (currentNode.value > value) {
                    parentNode = currentNode;
                    currentNode = currentNode.left;
                } else {
                    parentNode = currentNode;
                    currentNode = currentNode.right;
                }
            }
            currentNode = new Node(value);
            if (parentNode.value > value) {
                parentNode.left = currentNode;
            } else {
                parentNode.right = currentNode;
            }
        }
        return true;
    }

    public Node search(Integer value) {
        if (this.head == null) {
            return null;
        } else {
            Node node = this.head;
            while (node != null) {
                if (node.value == value) {
                    return node;
                }

                if (node.value > value) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
            return null;
        }
    }

    public boolean delete(Integer value) {
        boolean isFind = false;
        if (this.head == null) {
            return false;
        } else {
            Node currentNode = this.head;
            Node parentNode = this.head;
            if (currentNode.left == null && currentNode.right == null && currentNode.value == value) {
                this.head = null;
                return true;
            } else {
                while (currentNode != null) {
                    if (currentNode.value == value) {
                        isFind = true;
                        break;
                    }
                    if (currentNode.value > value) {
                        parentNode = currentNode;
                        currentNode = currentNode.left;
                    } else {
                        parentNode = currentNode;
                        currentNode = currentNode.right;
                    }
                }
            }
            if (!isFind) {
                return false;
            } else {
                if (currentNode.left == null && currentNode.right == null) {
                    if (parentNode.value > currentNode.value) {
                        parentNode.left = null;
                    } else {
                        parentNode.right = null;
                    }
                } else if (currentNode.left != null && currentNode.right == null) {
                    if (parentNode.value > currentNode.value) {
                        parentNode.left = currentNode.left;
                    } else {
                        parentNode.right = currentNode.left;
                    }

                } else if (currentNode.left == null && currentNode.right != null) {
                    if (parentNode.value > currentNode.value) {
                        parentNode.right = currentNode.left;
                    } else {
                        parentNode.right = currentNode.left;
                    }
                } else {
                    Node changeParentNode = currentNode.right;
                    Node changeNode = currentNode.right;
                    while (changeNode.left != null) {
                        changeParentNode = changeNode;
                        changeNode = changeNode.left;
                    }
                    if (changeNode.right != null) {
                        changeParentNode.left = changeNode.right;
                    } else {
                        changeParentNode.left = null;
                    }
                    if (parentNode.value > currentNode.value) {
                        parentNode.left = changeNode;
                        changeNode.left = currentNode.left;
                        changeNode.right = currentNode.right;
                    } else {
                        parentNode.right = changeNode;
                        changeNode.left = currentNode.left;
                        changeNode.right = currentNode.right;
                    }
                }
                return true;
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTreeTest myTree = new BinarySearchTreeTest();
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

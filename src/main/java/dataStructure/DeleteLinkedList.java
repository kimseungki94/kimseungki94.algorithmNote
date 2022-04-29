package dataStructure;

public class DeleteLinkedList<T> {
    Node<T> head = null;

    public class Node<T> {
        T data;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        if (this.head == null) {
            this.head = new Node<>(data);
        } else {
            Node<T> node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<>(data);
        }
    }

    public void printAll() {
        if (this.head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public void addNodeInside(T data, T isData) {
        Node<T> node = this.search(isData);
        if (node == null) {
            this.addNode(data);
        } else {
            Node<T> tempNode = node.next;
            node.next = new Node<T>(data);
            node.next.next = tempNode;
        }
    }

    public Node<T> search(T data) {
        if (this.head != null) {
            Node<T> node = this.head;
            while (node.next != null) {
                if (node.data == data) {
                    return node;
                }
                node = node.next;
            }
        }
        return null;
    }

    public boolean deleteNode(T isData) {
        if (this.head == null) {
            return false;
        } else {
            Node<T> node = this.head;
            while (node.next != null) {
                if (node.next.data == isData) {
                    node.next = node.next.next;
                    return true;
                }
                node = node.next;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        DeleteLinkedList<Integer> linkedList = new DeleteLinkedList<>();
        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.printAll();
        System.out.println();
        linkedList.addNodeInside(5, 2);
        linkedList.addNodeInside(13, 20);
        linkedList.printAll();
        System.out.println();
        linkedList.deleteNode(5);
        linkedList.printAll();
    }
}

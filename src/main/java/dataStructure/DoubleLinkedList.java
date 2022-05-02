package dataStructure;

public class DoubleLinkedList<T> {
    Node<T> head = null;
    Node<T> tail = null;

    public class Node<T> {
        Node<T> prev;
        Node<T> next;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }

    public void insertNode(T data) {
        if (this.head == null) {
            this.head = new Node<T>(data);
            this.tail = this.head;
        } else {
            Node<T> node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<T>(data);
            node.next.prev = node;
            this.tail = node.next;
        }
    }

    public void printAll() {
        if (this.tail != null) {
            Node<T> node = this.tail;
            System.out.println(node.data);
            while (node.prev != null) {
                node = node.prev;
                System.out.println(node.data);
            }
        }
    }

    public Node<T> TsearchFromHead(T data) {

        if (this.head == null) {
            return null;
        } else {
            Node<T> node = this.head;
            while (node != null) {
                if (node.data == data) {
                    return node;
                }
                node = node.next;
            }
            return null;
        }
    }

    public Node<T> TsearchFromTail(T data) {
        if (this.tail == null) {
            return null;
        } else {
            Node<T> node = this.tail;
            while (node != null) {
                if (node.data == data) {
                    return node;
                }
                node = node.prev;
            }
            return null;
        }
    }

    public void insertFrontNode(T data, T isData) {
        if (this.head.data == isData) {
            Node<T> node = this.head;
            node.prev = new Node<>(data);
            node.prev.next = node;
            node.next.prev = node;
        } else if (this.tail != null) {
            Node<T> node = TsearchFromTail(isData);
            Node<T> tempNode = node.prev;
            node.prev = new Node<>(data);
            node.prev.prev = tempNode;
            node.prev.next = node;
            node.prev.prev.next = node.prev;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> node = new DoubleLinkedList<>();
        node.insertNode(1);
        node.insertNode(2);
        node.insertNode(3);
        node.printAll();
        node.insertFrontNode(10, 2);
        node.insertFrontNode(0, 1);

        System.out.println();
        node.printAll();
    }
}

public class SinglyLL {
    public static void main(String[] args) {
        SingleLinkedList myList = new SingleLinkedList();
        myList.addNode(10);
        myList.addNode(20);
        myList.addNode(30);
        myList.addNode(40);
        myList.addNode(50);

//        myList.traverseLinkedList();

        myList.insertAtStart(60);

        myList.traverseLinkedList();

        System.out.println(myList.deleteNode(4));
        myList.traverseLinkedList();

        System.out.println("Length of Linked List: "+myList.lengthOfLinkedList());

        System.out.println(myList.searchElement(90));
    }
}

class SingleLinkedList {
    private Node head;
    private Node tempNode;

    private int size = 0;

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void addNode(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tempNode = head;
        }

        else {
            tempNode.next = newNode;
            tempNode = newNode;
        }
        size++;
    }

    public void traverseLinkedList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("END");
    }

    public void insertAtStart(int data) {
        Node newNode = new Node(data);
        if (head == null) head = newNode;
        else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public int deleteNode(int index) {
        if (index > size) return -1;

        if (index == 0) {
            int delData = head.data;
            head = head.next;
            size--;
            return delData;
        }

        Node delNode = head;
        int delData;

        for (int i = 0; i < index-1; i++) {
            delNode = delNode.next;
        }

        if (delNode.next.next != null) {
            delData = delNode.next.data;
            delNode.next = delNode.next.next;
        }

        else {
            delData = delNode.next.data;
            delNode.next = null;
        }

        size--;
        return delData;
    }

    public int lengthOfLinkedList() {
        return size;
    }

    public boolean searchElement(int element) {
        tempNode = head;

        while (tempNode != null) {
            if (tempNode.data == element) return true;
            tempNode = tempNode.next;
        }

        return false;
    }
}
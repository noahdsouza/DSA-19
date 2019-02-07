package your_code;

public class MyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Chicken val;
        Node prev;
        Node next;

        private Node(Chicken d, Node prev, Node next) {
            this.val = d;
            this.prev = prev;
            this.next = next;
        }

        private Node(Chicken d) {
            this.val = d;
            prev = null;
            next = null;
        }
    }

    public MyLinkedList() {
        // TODO
        head = new Node(null);
        tail = new Node(null);
        size = 0;

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Chicken c) {
        addLast(c);
    }

    public Chicken pop() {
        return removeLast();
    }

    public void addLast(Chicken c) {
        // TODO
        Node nl = new Node(c);
        if (size == 0) {
            tail = nl;
            head = tail;
            size++;
        } else {
            Node temp = tail;
            tail = new Node(c,temp,null);
            temp.next = tail;
            size++;
        }
    }

    public void addFirst(Chicken c) {
        // TODO
        Node nl = new Node(c);
        if (size == 0) {
            head = nl;
            tail = head;
            size++;
        } else {
            Node temp = head;
            head = new Node(c,null,temp);
            nl.prev = head;
            size++;
        }
    }

    public Chicken get(int index) {
        // TODO
        Node current = head;
        while (index > 0) {
            current = current.next;
            index--;
        }
        System.out.println(current.val.name);
        return current.val;
    }

    public Chicken remove(int index) {
        // TODO
        Node current = head;
        if (size == 0) {
            return null;
        } else if (size == 1) {
            Chicken temp = head.val;
            head = null;
            tail = null;
            size = size-1;
            return temp;
        } else {
            while (index > 0) {
                current = current.next;
                index--;
            }
            Chicken removed = current.val;
            if (current != tail && current != head) {
                current.next.prev = current.prev;
                current.prev.next = current.next;
                size = size-1;
            } else if (current == head) {
                current.next.prev = null;
                head = current.next;
                size = size-1;
            } else if (current == tail) {
                current.prev.next = null;
                tail = current.prev;
                size = size-1;
            }
//            System.out.println(current.val.name);
            return removed;
        }
    }

    public Chicken removeFirst() {
        // TODO
        Node removed = head;
        if (size == 0) {
            return null;
        } else if (size == 1) {
            head = null;
            tail = null;
            size = size-1;
        } else {
            Node temp = head;
            temp.next.prev = null;
            head = temp.next;
            size = size-1;
        }
        return removed.val;
    }

    public Chicken removeLast() {
        // TODO
        Node removed = tail;
        if (size == 0) {
            return null;
        } else if (size == 1) {
            head = null;
            tail = null;
            size = size-1;
        } else {
            Node temp = tail;
            temp.prev.next = null;
            tail = temp.prev;
            size = size-1;
        }
        return removed.val;
    }
}
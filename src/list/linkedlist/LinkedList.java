package list.linkedlist;

import java.util.Objects;

public class LinkedList {

    private Node head;          // 첫번째 노드를 가리키는 필드
    private Node tail;          // 마지막 노드를 가리키는 필드
    private int size = 0;       // 리스트 사이즈

    // Inner Class
    private class Node {

        private Object data;    // 데이터가 저장될 필드
        private Node next;      // 다음 노드를 가리키는 필드
        public Node(Object input) {
            this.data = input;
            this.next = null;
        }
        public String toString() {
            return String.valueOf(this.data);
        }

    }

    public void addFirst(Object input) {
        Node newNode = new Node(input);
        newNode.next = head;
        head = newNode;
        size++;
        if (head.next == null) {
            tail = head;
        }
    }

    public void addLast(Object input) {
        Node newNode = new Node(input);
        if (size == 0) {
            addFirst(input);
        } else {
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    // 내부적으로만 사용되어야 하는 메서드
    private Node node(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        Node x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    public void add(int k, Object input) {
        if (k == 0) {
            addFirst(input);
        } else {
            Node temp1 = node(k - 1);
            Node temp2 = temp1.next;
            Node newNode = new Node(input);
            temp1.next = newNode;
            newNode.next = temp2;
            size++;
            if (newNode.next == null) {
                tail = newNode;
            }
        }
    }

    public String toString() {
        if (head == null) {
            return "[]";
        }
        Node temp = head;
        String str = "[";

        while (temp.next != null) {
            str += temp.data + ", ";
            temp = temp.next;
        }
        str += temp.data;  // 마지막 노드

        return str + "]";
    }

    public Object removeFirst() {
        Node temp = head;
        head = temp.next;
        Object returnData = temp.data;
        temp = null;
        size--;
        return returnData;
    }

    public Object remove(int k) {
        if (k == 0) {
            return removeFirst();
        } else {
            Node temp = node(k - 1);
            Node toDelete = temp.next;
            temp.next = temp.next.next;
            Object returnData = toDelete.data;
            if (toDelete == tail) {
                tail = temp;
            }
            toDelete = null;
            size--;
            return returnData;
        }
    }

    public Object removeLast() {
        return remove(size - 1);
    }

    public int size() {
        return size;
    }

    public Object get(int k) {
        Node temp = node(k);
        return temp.data;
    }

    public int indexOf(Object data) {
        Node temp = head;
        int index = 0;
        while (!Objects.equals(temp.data, data)) {
            temp = temp.next;
            index++;
            if (temp == null) {
                return -1;
            }
        }
        return index;
    }

    public ListIterator listIterator() {
        return new ListIterator();
    }

    class ListIterator {

        private Node next;
        private Node lastReturned;
        private int nextIndex;

        public ListIterator() {
            next = head;
        }

        public Object next() {
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.data;
        }

        public boolean hasNext() {
            return nextIndex < size();
        }

        public void add(Object input) {
            Node newNode = new Node(input);
            if (lastReturned == null) {
                head = newNode;
            } else {
                lastReturned.next = newNode;
            }
            newNode.next = next;
            lastReturned = newNode;
            nextIndex++;
            size++;
        }

        public void remove() {
            if (nextIndex == 0) {  // 현재 아무 element 도 선택하지 않은 상태
                throw new IllegalStateException();
            }
            LinkedList.this.remove(nextIndex - 1);
            nextIndex--;
        }
    }
}

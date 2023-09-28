public class MyQueue {
    private Node front;
    private Node rear;
    private int size;

    private class Node {
        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
        }
    }

    public MyQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void add(Object value) {
        Node newNode = new Node(value);
        if (front == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (front == null) {
            throw new NoSuchElementException();
        }
        return front.data;
    }

    public Object poll() {
        if (front == null) {
            throw new NoSuchElementException();
        }
        Object data = front.data;
        front = front.next;
        size--;
        return data;
    }
}

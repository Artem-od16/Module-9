public class MyHashMap {
    private static final int DEFAULT_CAPACITY = 16;
    private Node[] table;
    private int size;

    private class Node {
        Object key;
        Object value;
        Node next;

        Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    private int hash(Object key) {
        return key.hashCode() % table.length;
    }

    public void put(Object key, Object value) {
        int index = hash(key);
        Node newNode = new Node(key, value);
        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node current = table[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value; // Обновляем значение, если ключ уже существует
                    return;
                }
                current = current.next;
            }
            if (current.key.equals(key)) {
                current.value = value; // Обновляем значение, если ключ уже существует
            } else {
                current.next = newNode;
            }
        }
        size++;
    }

    public void remove(Object key) {
        int index = hash(key);
        Node current = table[index];
        Node prev = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void clear() {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(Object key) {
        int index = hash(key);
        Node current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null; // Ключ не найден
    }
}

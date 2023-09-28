public class MyArrayList {
    private Object[] array;
    private int size;

    public MyArrayList() {
        array = new Object[10]; // начальная емкость массива
        size = 0;
    }

    public void add(Object value) {
        if (size == array.length) {
            // Увеличиваем размер массива при необходимости
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        array[size] = value;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[size - 1] = null; // Очищаем последний элемент
        size--;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }
}


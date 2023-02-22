package dalist;

public class SimpleArrayList<T> implements SimpleList<T> {
    private T[] elements;
    private int size;

    public SimpleArrayList() {
        this.size = 0;
        this.elements = (T[]) new Object[2];
    }

    @Override
    public boolean add(T value) {
        extendArray();
        this.elements[size] = value;
        size++;
        return true;
    }

    private void extendArray() {
        if (this.size == this.elements.length) {
            makeNewElements();
        }
    }

    private void makeNewElements() {
        T[] newElements = (T[]) new Object[this.elements.length * 2];
        for (int index = 0; index < this.size; index++) {
            newElements[index] = this.elements[index];
        }
        this.elements = newElements.clone();
    }

    @Override
    public void add(int index, T value) {
        validateIndexOutOfRange(index);
        T[] newElements = makeStringArray();
        for (int i = 0; i < index; i++) {
            newElements[i] = this.elements[i];
        }
        newElements[index] = value;
        for (int i = index; i < size; i++) {
            newElements[i + 1] = elements[i];
        }
        this.elements = newElements;
        size++;
    }

    private T[] makeStringArray() {
        if (this.size + 1 == this.elements.length) {
            return (T[]) new Object[this.elements.length * 2];
        }
        return (T[]) new Object[this.elements.length];
    }

    private void validateIndexOutOfRange(int index) {
        if (0 > index || size <= index) {
            throw new ArrayIndexOutOfBoundsException("");
        }
    }

    @Override
    public T set(int index, T value) {
        validateIndexOutOfRange(index);
        T returnValue = this.elements[index];
        this.elements[index] = value;
        return returnValue;
    }

    @Override
    public T get(int index) {
        validateIndexOutOfRange(index);
        return this.elements[index];
    }

    @Override
    public boolean contains(T value) {
        for (T element : elements) {
            if (value.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(T value) {
        for (int index = 0; index < size; index++) {
            if (value.equals(elements[index])) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean remove(T value) {
        for (int index = 0; index < size; index++) {
            if (value.equals(elements[index])) {
                remove(index);
                return true;
            }
        }
        throw new NullPointerException("");
    }

    @Override
    public T remove(int index) {
        validateIndexOutOfRange(index);
        T[] newElements = (T[]) new Object[this.elements.length];
        for (int i = 0; i < index; i++) {
            newElements[i] = this.elements[i];
        }
        for (int i = index; i < this.size; i++) {
            newElements[i] = this.elements[i + 1];
        }
        size--;
        T returnValue = this.elements[index];
        this.elements = newElements.clone();
        return returnValue;
    }

    @Override
    public void clear() {
        this.elements = (T[]) new Object[2];
        this.size = 0;
    }
}

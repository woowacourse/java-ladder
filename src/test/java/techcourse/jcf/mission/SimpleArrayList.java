package techcourse.jcf.mission;

public class SimpleArrayList implements SimpleList{

    private String[] arr;
    private int capacity;
    private int size;

    public SimpleArrayList() {
        this.capacity =1;
        this.size = 0;
        this.arr = new String[capacity];
    }

    @Override
    public boolean add(String value) {
        if(size == capacity){
            capacity *= 2;
            String[] newArr = new String[capacity];
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }

        arr[size] = value;
        size += 1;
        return true;
    }

    @Override
    public void add(int index, String value) {

    }

    @Override
    public String set(int index, String value) {
        return null;
    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public boolean contains(String value) {
        return false;
    }

    @Override
    public int indexOf(String value) {
        return 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean remove(String value) {
        return false;
    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public void clear() {

    }
}

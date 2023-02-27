package techcourse.jcf.mission;

public class ArrayList implements SimpleList {

    private String[] array;

    public ArrayList() {
        array = new String[0];
    }

    @Override
    public boolean add(String value) {
        String[] newArray = new String[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = value;
        array = newArray;
        return true;
    }

    @Override
    public void add(int index, String value) {
        if (index < 0 || index > array.length) throw new IndexOutOfBoundsException();
        String[] newArray = new String[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, index);
        newArray[index] = value;
        if (newArray.length - (index + 1) >= 0)
            System.arraycopy(array, index + 1 - 1, newArray, index + 1, newArray.length - (index + 1));
        array = newArray;
    }

    @Override
    public String set(int index, String value) {
        if (index < 0 || index > array.length) throw new IndexOutOfBoundsException();
        String oldValue = array[index];
        array[index] = value;
        return oldValue;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index > array.length) throw new IndexOutOfBoundsException();
        return array[index];
    }

    @Override
    public boolean contains(String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) return true;
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) return i;
        }
        return -1;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public boolean remove(String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                String[] newArray = new String[array.length - 1];
                System.arraycopy(array, 0, newArray, 0, i);
                if (newArray.length - i >= 0) System.arraycopy(array, i + 1, newArray, i, newArray.length - i);
                array = newArray;
                return true;
            }
        }
        return false;
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index > array.length) throw new IndexOutOfBoundsException();
        String[] newArray = new String[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        if (newArray.length - index >= 0) System.arraycopy(array, index + 1, newArray, index, newArray.length - index);
        array = newArray;
        return array[index];
    }

    @Override
    public void clear() {
        array = new String[0];
    }
}

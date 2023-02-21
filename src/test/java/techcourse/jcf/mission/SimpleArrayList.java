package techcourse.jcf.mission;

public class SimpleArrayList {

    private String[] simpleArrayList;
    private int size;

    public SimpleArrayList() {
        simpleArrayList = new String[2];
        size = 0;
    }

    boolean add(String value) {
        if (size == simpleArrayList.length) {
            makeListSizeDouble();
        }
        simpleArrayList[size] = value;
        size += 1;
        return true;
    }

    void add(int index, String value) throws Exception {
        if (index >= size || index < 0) {
            throw new Exception();
        }
        if (size == simpleArrayList.length) {
            makeListSizeDouble();
        }
        for (int count = 0; count < size; count++) {
            if (count > index) {
                simpleArrayList[count] = simpleArrayList[count - 1];
            }
            simpleArrayList[index] = value;
        }
        size += 1;
    }

    String set(int index, String value) throws Exception {
        if (index >= size || index < 0) {
            throw new Exception();
        }
        String targetValue = simpleArrayList[index];
        simpleArrayList[index] = value;
        return targetValue;
    }

    String get(int index) throws Exception {
        if (index >= size || index < 0) {
            throw new Exception();
        }
        return simpleArrayList[index];
    }

    boolean contains(String value) {
        for (int count = 0; count < size; count++) {
            if (value.equals(simpleArrayList[count])) {
                return true;
            }
        }
        return false;
    }

    int indexOf(String value) throws Exception {
        for (int count = 0; count < size; count++) {
            if (value.equals(simpleArrayList[count])) {
                return count;
            }
        }
        throw new Exception();
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    String remove(int index) throws Exception {
        if (index >= size || index < 0) {
            throw new Exception();
        }
        String indexValue = simpleArrayList[index];
        for (int count = index + 1; count < size; count++) {
            simpleArrayList[count - 1] = simpleArrayList[count];
        }
        size -= 1;
        return indexValue;
    }

    boolean remove(String value) {
        int index = -1;
        for (int count = 0; count < size; count++) {
            if (value.equals(simpleArrayList[count])) {
                index = count;
            }
        }
        if (index > -1) {
            for (int count = index + 1; count < size; count++) {
                simpleArrayList[count - 1] = simpleArrayList[count];
            }
            size -= 1;
            return true;
        }
        return false;
    } //배열의 크기가 작아지면 다시 동적으로 크기를 조절하 것인지?

    void clear() {
        simpleArrayList = new String[2];
        size = 0;
    }

    private void makeListSizeDouble() {
        String[] simpleArrayList = new String[size * 2];
        for (int index = 0; index < size; index++) {
            simpleArrayList[index] = this.simpleArrayList[index];
        }
        this.simpleArrayList = simpleArrayList;
    }
}

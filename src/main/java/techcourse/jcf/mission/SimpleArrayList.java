package techcourse.jcf.mission;

public class SimpleArrayList implements SimpleList {
    private final int fixedSize = 10;
    private String[] arrayList;
    private int point = 0;

    public SimpleArrayList() {
        this.arrayList = new String[fixedSize];
    }

    @Override
    public boolean add(String value) {
        beforeAdd(value);
        arrayList[point] = value;
        point += 1;
        return true;
    }

    private void beforeAdd(String value) {
        checkNull(value);

        if (point == arrayList.length) {
            String[] copy = new String[arrayList.length + fixedSize];
            for (int i = 0; i < point; i++) {
                copy[i] = arrayList[point];
            }
            this.arrayList = copy;
        }
    }

    private void checkNull(String value) {
        if (value == null) {
            throw new NullPointerException();
        }
    }

    @Override
    public void add(int index, String value) {
        checkBound(index);
        beforeAdd(value);

        String[] copy = new String[arrayList.length];
        for (int i = 0; i < arrayList.length; i++) {
            if (i < index) {
                copy[i] = arrayList[i];
            }
            if (i == index) {
                copy[index] = value;
            }
            if (i > index) {
                copy[i] = arrayList[i - 1];
            }
        }
        this.arrayList = copy;
        point += 1;
    }

    private void checkBound(int index) {
        if (index > point - 1) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String set(int index, String value) {
        checkBound(index);
        String originalValue = arrayList[index];

        String[] copy = new String[arrayList.length];
        for (int i = 0; i < arrayList.length; i++) {
            if (i < index) {
                copy[i] = arrayList[i];
            }
            if (i == index) {
                copy[index] = value;
            }
            if (i > index) {
                copy[i] = arrayList[i];
            }
        }
        this.arrayList = copy;
        return originalValue;
    }

    @Override
    public String get(int index) {
        checkBound(index);
        return arrayList[index];
    }

    @Override
    public boolean contains(String value) {
        checkNull(value);
        for (String arrayValue : arrayList) {
            if (value.equals(arrayValue)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        for (int i = 0; i < point; i++) {
            if (value.equals(arrayList[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return point;
    }

    @Override
    public boolean isEmpty() {
        return point == 0;
    }

    @Override
    public boolean remove(String value) {
        if (contains(value)) {
            int index = indexOf(value);
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public String remove(int index) {
        checkBound(index);
        String originalValue = arrayList[index];

        String[] copy = new String[arrayList.length];
        for (int i = 0; i < point; i++) {
            if (i < index) {
                copy[i] = arrayList[i];
            }
            if (i >= index) {
                copy[i] = arrayList[i + 1];
            }
        }
        this.arrayList = copy;
        point -= 1;
        return originalValue;
    }

    @Override
    public void clear() {
        this.arrayList = new String[fixedSize];
        this.point = 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (int i = 0; i < point; i++) {
            String coma = i == point - 1 ? "" : ", ";
            stringBuilder.append(arrayList[i]).append(coma);
        }
        return stringBuilder.append("}").toString();
    }
}

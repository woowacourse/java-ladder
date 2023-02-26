package study;

public class SimpleArrayList implements SimpleList {
    String[] arrayList;

    public SimpleArrayList() {
        arrayList = new String[0];
    }

    @Override
    public boolean add(String value) {
        String[] tempArrayList = new String[arrayList.length + 1];
        System.arraycopy(arrayList, 0, tempArrayList, 0, arrayList.length);
        tempArrayList[arrayList.length] = value;
        arrayList = tempArrayList;
        return true;
    }

    @Override
    public void add(int index, String value) {
        int listIndex = 0;
        int tempIndex = 0;
        String[] tempArrayList = new String[arrayList.length + 1];
        while (listIndex < arrayList.length) {
            if (tempIndex == index) {
                tempArrayList[tempIndex] = value;
            } else {
                tempArrayList[tempIndex] = arrayList[listIndex];
                listIndex++;
            }
            tempIndex++;
        }
        arrayList = tempArrayList;
    }

    @Override
    public String set(int index, String value) {
        String oldValue = arrayList[index];
        arrayList[index] = value;
        return oldValue;
    }

    @Override
    public String get(int index) {
        return arrayList[index];
    }

    @Override
    public boolean contains(String value) {
        boolean isContain = false;
        for (String s : arrayList) {
            if (s.equals(value)) {
                isContain = true;
                break;
            }
        }
        return isContain;
    }

    @Override
    public int indexOf(String value) {
        int index = -1;
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i].equals(value)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int size() {
        return arrayList.length;
    }

    @Override
    public boolean isEmpty() {
        return arrayList.length == 0;
    }

    @Override
    public boolean remove(String value) {
        String[] tempArrayList = new String[arrayList.length - 1];
        boolean isRemove = false;
        int index = 0;
        for (String element : arrayList) {
            if (!isRemove && element.equals(value)) {
                isRemove = true;
                continue;
            }
            tempArrayList[index] = element;
            index++;
        }
        arrayList = tempArrayList;
        return isRemove;
    }

    @Override
    public String remove(int index) {
        String[] tempArrayList = new String[arrayList.length - 1];
        String oldValue = arrayList[index];
        int tempIndex = 0;
        for (int i = 0; i < arrayList.length; i++) {
            if (i == index) {
                continue;
            }
            tempArrayList[tempIndex] = arrayList[i];
            tempIndex++;
        }
        arrayList = tempArrayList;
        return oldValue;
    }

    @Override
    public void clear() {
        arrayList = new String[0];
    }
}

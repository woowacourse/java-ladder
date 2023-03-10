package techcourse.jcf.mission;

import java.util.Arrays;
import java.util.Objects;

public class SimpleArrayList implements SimpleList {
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private static final int DEFAULT_CAPACITY = 10;
    private static final String[] EMPTY_ELEMENTDATA = {};
    private static final String[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    private String[] elementData;
    private int size;
    /*
     * 리스트가 구조적으로 사이즈 변경이 이뤄진 횟수, iterator 순회 과정에서 변경됨이 확인되면 fast fail 하도록 할때 사용 가능
     * 보통 add, remove 메서드에서 사용
     * abstract List에 선언되어 있는데 하위 클래스에서 fast fail을 사용하지 않는다면 무시해도 된다고 함.
     */
    private int modCount = 0;

    public SimpleArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new String[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }

    public SimpleArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    @Override
    public boolean add(String value) {
        modCount++;
        if (size == elementData.length) {
            elementData = grow();
        }
        elementData[size] = value;
        size++;
        return true;
    }

    @Override
    public void add(int index, String value) {
        rangeCheckForAdd(index); //index 값 검증 후 이상 시 예외처리
        modCount++;
        final int s;
        String[] elementData;
        if ((s = size) == (elementData = this.elementData).length)
            elementData = grow();
        System.arraycopy(elementData, index,
                elementData, index + 1,
                s - index);
        elementData[index] = value;
        size = s + 1;
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("index Error" + index);
    }

    @Override
    public String set(int index, String value) {
        Objects.checkIndex(index, size);
        String oldValue = elementData(index);
        elementData[index] = value;
        return oldValue;
    }

    @Override
    public String get(int index) {
        Objects.checkIndex(index, size);
        return elementData(index);
    }

    //추후 제네릭 추가되야 할 듯
    private String elementData(int index) {
        return elementData[index];
    }

    @Override
    public boolean contains(String value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(String value) {
        return indexOfRange(value, 0, size);
    }

    private int indexOfRange(String value, int start, int end) {
        String[] es = elementData;
        if (value == null) {
            for (int i = start; i < end; i++) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = start; i < end; i++) {
                if (value.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(String value) {
        final String[] es = elementData;
        final int size = this.size();
        int i = 0;
        found:
        {
            if (value == null) {
                for (; i < size; i++)
                    if (es[i] == null)
                        break found;
            } else {
                for (; i < size; i++)
                    if (value.equals(es[i]))
                        break found;
            }
            return false;
        }
        fastRemove(es, i);
        return false;
    }

    private void fastRemove(String[] es, int i) {
        modCount++;
        final int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(es, i+1, es, i, newSize - i);
        es[size = newSize] = null;

    }

    @Override
    public String remove(int index) {
        Objects.checkIndex(index, size);
        final String[] es = elementData;

        // 제네릭 미션 진행 시 여기에 추가 코드 들어가야 할 듯
        String oldValue = es[index];
        fastRemove(es, index);

        return oldValue;
    }

    @Override
    public void clear() {
        modCount++;
        final String[] es = elementData;
        for (int to = size, i = size = 0; i < to; i++) {
            es[i] = null;
        }
    }


    private String[] grow() {
        return grow(size + 1);
    }

    private String[] grow(int minCapacity) {
        return elementData = Arrays.copyOf(elementData, newCapacity(minCapacity));
    }

    private int newCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity <= 0) {
            if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
                return Math.max(DEFAULT_CAPACITY, minCapacity);
            if (minCapacity < 0) //overflow
                throw new OutOfMemoryError();
            return minCapacity;
        }
        return (newCapacity - MAX_ARRAY_SIZE <= 0)
                ? newCapacity
                : hugeCapacity(minCapacity);
    }

    private int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE)
                ? Integer.MAX_VALUE
                : MAX_ARRAY_SIZE; // 실제로는 사용되지 않는 값...?
    }
}

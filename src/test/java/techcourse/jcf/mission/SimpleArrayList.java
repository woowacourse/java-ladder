package techcourse.jcf.mission;

public class SimpleArrayList implements SimpleList {
    private final static int DEFAULT_SIZE = 16;

    private ArrayNode[] arrayNodes;
    private int index = 0;

    public SimpleArrayList() {
        this.arrayNodes = new ArrayNode[DEFAULT_SIZE];
    }

    @Override
    public boolean add(String value) {
        if (index >= arrayNodes.length - 1) {
            increaseArraySize();
        }
        arrayNodes[index++] = new ArrayNode(value);
        return true;
    }

    private void increaseArraySize() {
        ArrayNode[] newArrayNodes = new ArrayNode[arrayNodes.length * 2];
        System.arraycopy(arrayNodes, 0, newArrayNodes, 0, index);
        this.arrayNodes = newArrayNodes;
    }

    @Override
    public void add(int index, String value) {
        ArrayNode arrayNode = new ArrayNode(value);
        if (index >= arrayNodes.length - 1) {
            increaseArraySize();
        }
        for (int i = index; i <= this.index; i++) {
            arrayNodes[i] = arrayNodes[i + 1];
        }
        arrayNodes[index] = arrayNode;
        this.index++;
    }

    @Override
    public String set(int index, String value) {
        arrayNodes[index] = new ArrayNode(value);
        return value;
    }

    @Override
    public String get(int index) {
        return arrayNodes[index].getValue();
    }

    @Override
    public boolean contains(String value) {
        for (int i = 0; i < index; i++) {
            if (arrayNodes[i].isValueMatch(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        for (int i = 0; i < index; i++) {
            if (arrayNodes[i].isValueMatch(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public boolean remove(String value) {
        int targetIndex = indexOf(value);
        if (targetIndex == -1) {
            return false;
        }
        removeTarget(targetIndex);
        return true;
    }

    private void removeTarget(int targetIndex) {
        for (int i = targetIndex; i <= index; i++) {
            arrayNodes[i] = arrayNodes[i + 1];
        }
        index--;
    }

    @Override
    public String remove(int index) {
        ArrayNode target = arrayNodes[index];
        removeTarget(index);
        return target.getValue();
    }

    @Override
    public void clear() {
        this.arrayNodes = new ArrayNode[DEFAULT_SIZE];
        this.index = 0;
    }
}

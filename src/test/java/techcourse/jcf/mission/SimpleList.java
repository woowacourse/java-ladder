package techcourse.jcf.mission;

// TODO: 제네릭을 사용하지 않는다. String만 다루는 리스트를 구현한다.
public interface SimpleList {

    boolean add(String value);

    void add(int index, String value);

    String set(int index, String value);

    String get(int index);

    boolean contains(String value);

    int indexOf(String value);

    int size();

    boolean isEmpty();

    boolean remove(String value);

    String remove(int index);

    void clear();
}

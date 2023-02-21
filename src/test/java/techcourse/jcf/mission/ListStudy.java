package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


public class ListStudy {

    @Test
    public void arrayList() {
        SimpleList arrayList = new SimpleArrayList();
        arrayList.add("first");
        arrayList.add("second");

        assertThat(arrayList.add("third")).isTrue(); // 세 번째 값을 추가한다.
        assertThat(arrayList.size()).isEqualTo(3); // list의 크기를 구한다.
        assertThat(arrayList.get(0)).isEqualTo("first"); // 첫 번째 값을 찾는다.
        assertThat(arrayList.contains("first")).isTrue(); // "first" 값이 포함되어 있는지를 확인한다.
        assertThat(arrayList.remove(0)).isEqualTo("first"); // 첫 번째 값을 삭제한다.
        assertThat(arrayList.size()).isEqualTo(2); // 값이 삭제 됐는지 확인한다.
    }

    @Test
    public void linkedList() {
        SimpleList linkedList = new SimpleLinkedList();
        linkedList.add("first");
        linkedList.add("second");

        assertThat(linkedList.add("third")).isTrue(); // 세 번째 값을 추가한다.
        assertThat(linkedList.size()).isEqualTo(3); // list의 크기를 구한다.
        assertThat(linkedList.get(0)).isEqualTo("first"); // 첫 번째 값을 찾는다.
        assertThat(linkedList.contains("first")).isTrue(); // "first" 값이 포함되어 있는지를 확인한다.
        assertThat(linkedList.remove(0)).isEqualTo("first"); // 첫 번째 값을 삭제한다.
        assertThat(linkedList.size()).isEqualTo(2); // 값이 삭제 됐는지 확인한다.
    }

    @Test
    void test() {
        SimpleList arrayList = new SimpleArrayList();
        arrayList.add("first");
        arrayList.add("second");
        arrayList.add(0, "zero"); // 첫 번째 값을 추가한다.

        assertThat(arrayList.add("third")).isTrue(); // 네 번째 값을 추가한다.
        assertThat(arrayList.set(2, "changedSecond")).isEqualTo("second"); // 두 번째 값을 변경한다.
        assertThat(arrayList.get(2)).isEqualTo("changedSecond"); // 변경된 두 번 째 값을 확인한다.
        assertThat(arrayList.size()).isEqualTo(4); // list의 크기를 구한다.
        assertThat(arrayList.get(0)).isEqualTo("zero"); // 첫 번째 값을 찾는다.
        assertThat(arrayList.contains("first")).isTrue(); // "first" 값이 포함되어 있는지를 확인한다.
        assertThat(arrayList.remove(0)).isEqualTo("zero"); // 첫 번째 값을 삭제한다.
        assertThat(arrayList.size()).isEqualTo(3); // 값이 삭제 됐는지 확인한다.
        assertThat(arrayList.isEmpty()).isFalse(); // 값이 비어있지 않음을 확인한다.
        assertThat(arrayList.remove("first")).isTrue(); // "first"값을 삭제한다.
        assertThat(arrayList.size()).isEqualTo(2); // 값이 삭제 됐는지 확인한다.
        assertThat(arrayList.toString()).isEqualTo("[changedSecond, third]"); // values에 담긴 모든 값을 출력한다.
        arrayList.clear(); // 리스트를 초기화 한다.
        assertThat(arrayList.isEmpty()).isTrue(); // 값이 비어있음을 확인한다.
    }

    @Test
    void test1() {
        SimpleList arrayList = new SimpleLinkedList();
        arrayList.add("first");
        arrayList.add("second");
        arrayList.add(0, "zero"); // 첫 번째 값을 추가한다.

        assertThat(arrayList.add("third")).isTrue(); // 네 번째 값을 추가한다.
        assertThat(arrayList.set(2, "changedSecond")).isEqualTo("second"); // 두 번째 값을 변경한다.
        assertThat(arrayList.get(2)).isEqualTo("changedSecond"); // 변경된 두 번 째 값을 확인한다.
        assertThat(arrayList.size()).isEqualTo(4); // list의 크기를 구한다.
        assertThat(arrayList.get(0)).isEqualTo("zero"); // 첫 번째 값을 찾는다.
        assertThat(arrayList.contains("first")).isTrue(); // "first" 값이 포함되어 있는지를 확인한다.
        assertThat(arrayList.remove(0)).isEqualTo("zero"); // 첫 번째 값을 삭제한다.
        assertThat(arrayList.size()).isEqualTo(3); // 값이 삭제 됐는지 확인한다.
        assertThat(arrayList.isEmpty()).isFalse(); // 값이 비어있지 않음을 확인한다.
        assertThat(arrayList.remove("first")).isTrue(); // "first"값을 삭제한다.
        assertThat(arrayList.size()).isEqualTo(2); // 값이 삭제 됐는지 확인한다.
        assertThat(arrayList.toString()).isEqualTo("[changedSecond, third]"); // values에 담긴 모든 값을 출력한다.
        arrayList.clear(); // 리스트를 초기화 한다.
        assertThat(arrayList.isEmpty()).isTrue(); // 값이 비어있음을 확인한다.
    }
}

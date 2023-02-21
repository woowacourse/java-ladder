package techcourse.jcf.mission;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ListStudy {

    @Test
    public void arrayList() {
        SimpleArrayList simpleArrayList = new SimpleArrayList();
        simpleArrayList.add("first");
        simpleArrayList.add("second");

        assertThat(simpleArrayList.add("third")).isTrue(); // 세 번째 값을 추가한다.
        assertThat(simpleArrayList.size()).isEqualTo(3); // list의 크기를 구한다.
        assertThat(simpleArrayList.get(0)).isEqualTo("first"); // 첫 번째 값을 찾는다.
        assertThat(simpleArrayList.contains("first")).isTrue(); // "first" 값이 포함되어 있는지를 확인한다.
        assertThat(simpleArrayList.remove(0)).isEqualTo("first"); // 첫 번째 값을 삭제한다.
        assertThat(simpleArrayList.size()).isEqualTo(2); // 값이 삭제 됐는지 확인한다.

        // TODO values에 담긴 모든 값을 출력한다.
        for (int i = 0; i < simpleArrayList.size(); i++) {
            System.out.println(simpleArrayList.get(i));
        }
    }

    @Test
    public void linkedList() {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.add("first");
        simpleLinkedList.add("second");

        assertThat(simpleLinkedList.add("third")).isTrue(); // 세 번째 값을 추가한다.
        assertThat(simpleLinkedList.size()).isEqualTo(3); // list의 크기를 구한다.
        assertThat(simpleLinkedList.get(0)).isEqualTo("first"); // 첫 번째 값을 찾는다.
        assertThat(simpleLinkedList.contains("first")).isTrue(); // "first" 값이 포함되어 있는지를 확인한다.
        assertThat(simpleLinkedList.remove(0)).isEqualTo("first"); // 첫 번째 값을 삭제한다.
        assertThat(simpleLinkedList.size()).isEqualTo(2); // 값이 삭제 됐는지 확인한다.
        // TODO values에 담긴 모든 값을 출력한다.
        for (int i = 0; i < simpleLinkedList.size(); i++) {
            System.out.println(simpleLinkedList.get(i));
        }
    }
}

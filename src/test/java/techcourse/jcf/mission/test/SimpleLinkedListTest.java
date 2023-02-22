package techcourse.jcf.mission.test;

import org.junit.jupiter.api.Test;
import techcourse.jcf.mission.SimpleLinkedList;
import techcourse.jcf.mission.SimpleList;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleLinkedListTest {


    @Test
    public void linkedListTest() {
        SimpleList list = new SimpleLinkedList();

        list.add("first");
        list.add("second");

        assertThat(list.add("third")).isTrue(); // 세 번째 값을 추가한다.
        assertThat(list.size()).isEqualTo(3); // list의 크기를 구한다.
        assertThat(list.get(0)).isEqualTo("first"); // 첫 번째 값을 찾는다.
        assertThat(list.contains("first")).isTrue(); // "first" 값이 포함되어 있는지를 확인한다.
        assertThat(list.remove(0)).isEqualTo("first"); // 첫 번째 값을 삭제한다.
        assertThat(list.size()).isEqualTo(2); // 값이 삭제 됐는지 확인한다.
    }

}

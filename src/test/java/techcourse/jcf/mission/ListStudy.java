package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ListStudy {

    @Test
    public void arrayList() {
        ArrayList<String> values = new ArrayList<>();
        values.add("first");
        values.add("second");

        assertThat(values.add("third"))
                .isTrue(); // 세 번째 값을 추가한다.
        assertThat(values.size())
                .isEqualTo(3); // list의 크기를 구한다.
        assertThat(values.get(0))
                .isEqualTo("first"); // 첫 번째 값을 찾는다.
        assertThat(values.contains("first"))
                .isTrue(); // "first" 값이 포함되어 있는지를 확인한다.
        assertThat(values.remove(0))
                .isEqualTo("first"); // 첫 번째 값을 삭제한다.
        assertThat(values.size())
                .isEqualTo(2); // 값이 삭제 됐는지 확인한다.

        System.out.println(values);
    }

    @Test
    @DisplayName("SimpleArrayList Test")
    void simpleArrayList() {
        // given

        // when

        // then

    }

    @Test
    @DisplayName("SimpleLinkedList Test")
    void simpleLinkedTest() {
        // given
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.add("first");
        simpleLinkedList.add("second");

        // expect
        assertThat(simpleLinkedList.add("third"))
                .isTrue(); // 세 번째 값을 추가한다.
        assertThat(simpleLinkedList.size())
                .isEqualTo(3); // list의 크기를 구한다.
        assertThat(simpleLinkedList.get(0))
                .isEqualTo("first"); // 첫 번째 값을 찾는다.
        assertThat(simpleLinkedList.contains("first"))
                .isTrue(); // "first" 값이 포함되어 있는지를 확인한다.
        assertThat(simpleLinkedList.remove(0))
                .isEqualTo("first"); // 첫 번째 값을 삭제한다.
        assertThat(simpleLinkedList.size())
                .isEqualTo(2); // 값이 삭제 됐는지 확인한다.
    }
}

package domain;

import domain.ladder.Line;
import domain.ladder.Link;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("Line에서 연결된 부분의 index를 리스트 형태로 반환")
    void getLinkedIndexesTest() {
        final Line line = new Line(List.of(Link.LINKED, Link.UNLINKED, Link.LINKED));

        final List<Integer> indexes = line.getLinkedIndexes();

        Assertions.assertThat(indexes).containsExactly(0, 2);
    }
}

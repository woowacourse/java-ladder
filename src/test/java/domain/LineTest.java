package domain;

import domain.ladder.Line;
import domain.ladder.Link;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("Line에서 연결된 부분의 index를 List<Position> 형태로 반환")
    void getLinkedPositionsTest() {
        final Line line = new Line(List.of(Link.LINKED, Link.UNLINKED, Link.LINKED));

        final List<Position> positions = line.getLinkedPositions();

        Assertions.assertThat(positions)
                .containsExactly(new Position(0), new Position(2));
    }
}

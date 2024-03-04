package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ladder.domain.ladder.Row;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class RowTest {

    @Test
    @DisplayName("사람이 2명 보다 적다면 `IllegalArgumentException` 가 발생한다.")
    void testCreate1() {
        assertThatThrownBy(() -> new Row(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사람은 2명 이상이어야 한다.");
    }

    @RepeatedTest(5)
    @DisplayName("한 행을 내려간 후 위치는 가로 범위 이내 이다.")
    void testGoDown1() {
        Row row = new Row(2);

        int position0 = row.goDown(0);
        int position1 = row.goDown(1);
        assertAll(
                () -> assertTrue(0 <= position0 && position0 < row.size()),
                () -> assertTrue(0 <= position1 && position1 < row.size())
                );
    }

    @RepeatedTest(5)
    @DisplayName("다른 인덱스에서 시작한 사다리는 서로 다른 결과를 얻는다")
    void testGoDown2() {
        Row row = new Row(2);

        assertNotEquals(row.goDown(0), row.goDown(1));
    }
}

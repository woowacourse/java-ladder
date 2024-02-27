package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RowTest {

    static class TestLadderStrategy implements LadderStrategy {

        @Override
        public boolean creatable() {
            return true;
        }
    }

    @Test
    @DisplayName("사람이 2명 보다 적다면 `IllegalArgumentException` 가 발생한다.")
    void testCreate1() {
        assertThatThrownBy(() -> {
            new Row(1, new TestLadderStrategy());
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사람은 2명 이상이어야 한다.");
    }

    @Test
    @DisplayName("내려가기 전 위치를 입력하면 내려간 후 위치를 반환한다.")
    void testGoDown() {
        Row row = new Row(2, new TestLadderStrategy());
        int index = 0;

        assertEquals(1, row.goDown(index));
    }
}

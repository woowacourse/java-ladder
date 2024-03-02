package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class RowTest {

    @Test
    @DisplayName("사람이 2명 보다 적다면 `IllegalArgumentException` 가 발생한다.")
    void testCreate1() {
        assertThatThrownBy(() -> {
            new Row(1);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사람은 2명 이상이어야 한다.");
    }

    @RepeatedTest(5)
    @DisplayName("다른 인덱스에서 시작한 사다리는 서로 다른 결과를 얻는다")
    void testGoDown() {
        Row row = new Row(2);

        assertNotEquals(row.goDown(0), row.goDown(1));
    }
}

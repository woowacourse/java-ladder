package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ItemsTest {
    @Test
    @DisplayName("존재하지 않는 위치로 실행 결과를 찾는 경우 예외를 던진다.")
    void items_throwException_notFoundPositionOfItem() {
        // given
        Position wrongPosition = new Position(4);
        Items items = new Items(List.of("1", "2", "3"));

        // expected
        assertThatThrownBy(() -> items.findItem(wrongPosition))
                .isInstanceOf(IllegalStateException.class);
    }
}

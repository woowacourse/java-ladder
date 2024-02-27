package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MatchingItemsTest {

    @DisplayName("매칭 아이템의 수가 참가자 수와 일치하면 잘 생성된다.")
    @Test
    void createMatchingItems() {
        assertThatCode(() -> new MatchingItems(List.of("꽝", "3000", "꽝", "5000"), 4))
                .doesNotThrowAnyException();
    }

    @DisplayName("매칭 아이템의 수가 참가자 수와 일치하지 않으면 예외가 발생한다.")
    @Test
    void matchingItemCountDoesNotSameAsPlayerCount() {
        assertThatThrownBy(() -> new MatchingItems(List.of("꽝", "3000", "꽝", "5000"), 5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

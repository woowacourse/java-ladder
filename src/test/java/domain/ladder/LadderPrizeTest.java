package domain.ladder;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.player.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class LadderPrizeTest {

    @DisplayName("알맞은 값을 입력하면 정상적으로 생성된다.")
    @Test
    void create_success() {
        assertThatNoException().isThrownBy(() -> new LadderPrize("value", new Position(1)));
    }

    @DisplayName("결과 명칭이 공백이면 예외를 반환한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void create_fail_by_blank_value(String wrongValue) {
        assertThatThrownBy(() -> new LadderPrize(wrongValue, new Position(1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("경품명은 공백이거나 비어있을 수 없습니다.");
    }

    @DisplayName("결과 명칭의 길이가 5글자를 초과하면 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"123456", "1234567"})
    void create_fail_by_too_long_length(String wrongValue) {
        assertThatThrownBy(() -> new LadderPrize(wrongValue, new Position(1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("경품명은 1글자 이상, 5글자 이하여야합니다.");

    }
}

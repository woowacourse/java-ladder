package ladder.domain.prize;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PrizeTest {
    @Test
    @DisplayName("Prize 객체 생성 테스트")
    void createPrize() {
        String name = "꽝";
        Prize prize = new Prize(name);
        assertThat(prize.name()).isEqualTo(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    @DisplayName("이름의 길이가 범위를 벗어날 경우 예외를 발생한다.")
    void testInvalidNameRange(String name) {
        assertThatThrownBy(() -> new Prize(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

package ladder.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

class PlayerNameTest {

    @ParameterizedTest
    @DisplayName("플레이어 이름이 1자 미만 6자 이상이면 예외처리 테스트")
    @ValueSource(strings = {"이리내이리내", ""})
    void invalidNameLengthTest(String input) {
        Assertions.assertThatThrownBy(() -> new PlayerName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("플레이어 이름이 1자 이상 5자 이하면 통과 테스트")
    @ValueSource(strings = {"이리내", "이오", "이", "이리내이오"})
    void validNameLengthTest(String input) {
        assertThatCode(() -> new PlayerName(input)).doesNotThrowAnyException();
    }

}
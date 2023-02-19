package laddergame.domain.ladder;

import laddergame.domain.exception.BlankException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderResultNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"꽝", "3000"})
    @DisplayName("사다리 결과의 이름이 공백이 아니라면, 예외가 발생하지 않는다.")
    void create_thenSuccess(final String name) {
        assertThatCode(() -> LadderResultName.create(name))
                .doesNotThrowAnyException();

        assertThat(LadderResultName.create(name))
                .isInstanceOf(LadderResultName.class);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("사다리 결과의 이름이 공백이라면, 예외가 발생한다.")
    void create_givenBlankName_thenFail(final String name) {
        assertThatThrownBy(() -> LadderResultName.create(name))
                .isInstanceOf(IllegalArgumentException.class)
                .isExactlyInstanceOf(BlankException.class)
                .hasMessageContaining(String.format(BlankException.errorMessage, "사다리 결과 이름은"));
    }
}

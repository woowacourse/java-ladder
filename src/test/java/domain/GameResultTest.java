package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class GameResultTest {

    @DisplayName("실행 결과과 공백일 예외 처리 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void validateNullAndEmpty(String resultInput) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new GameResult(new Player("a", 0), resultInput));
    }

    @DisplayName("실행 결과명이 1글자 이상 5글자 이하가 아니면 예외 처리한다.")
    @Test
    void validateGameResultNameSize() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new GameResult(new Player("a", 0), "다섯글자이상"));
    }

    @DisplayName("실행 결과를 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"꽝", "3000", "20000"})
    void generateGameResult(String resultInput) {
        assertThatNoException()
                .isThrownBy(() -> new GameResult(new Player("a", 0), resultInput));
    }

    @DisplayName("실행 결과를 가져올 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"꽝", "3000", "20000"})
    void getGameResult(String expectedResult) {
        // given
        GameResult gameResult = new GameResult(new Player("a", 0), expectedResult);

        // when
        String gameResultName = gameResult.getGameResultName();

        // then
        assertThat(gameResultName)
                .isEqualTo(expectedResult);
    }

}

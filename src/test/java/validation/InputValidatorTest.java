package validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    void 플레이어_이름_입력이_빈칸이면_에러를_발생시킨다(String playerNames) {
        //when + then
        assertThatThrownBy(() -> InputValidator.validatePlayerNameInput(playerNames))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"가가가", "abc", "1234"})
    void 플레이어_이름_입력이_빈칸이_아니면_에러를_발생시키지_않는다(String playerNames) {
        //when + then
        assertDoesNotThrow(() -> InputValidator.validatePlayerNameInput(playerNames));
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"가", "1나", "abv", "!@", "", " ", "  ", "0", "-1", "10.1"})
    void 사다리_높이_입력이_숫자가_아니거나_양수가_아니면_에러를_발생시킨다(String ladderHeight) {
        //when + then
        assertThatThrownBy(() -> InputValidator.validateLadderHeightInput(ladderHeight))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "100"})
    void 사다리_높이_입력이_양의_정수이면_에러를_발생시키지_않는다(String ladderHeight) {
        //when + then
        assertDoesNotThrow(() -> InputValidator.validateLadderHeightInput(ladderHeight));
    }
}
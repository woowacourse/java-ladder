package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

public class GameResultTest {

    @DisplayName("실행 결과과 공백일 예외처리 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void validateNullAndEmpty(String resultInput) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new GameResult(resultInput));
    }


}

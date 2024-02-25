package ladderGame.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ResultTest {

    @ParameterizedTest
    @ValueSource(strings = {"123456", "꽝꽝", "-1", ""})
    @DisplayName("실행 결과는 6글자 이상일 시 예외처리 된다.")
    void validateResultLength(String result) {
        assertThatThrownBy(() -> new Result(result))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과는 꽝 또는 0 이상 99999 이하의 숫자만 입력 가능합니다.");
    }

}

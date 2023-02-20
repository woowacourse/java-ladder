package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ResultContentTest {

    @DisplayName("실행결과의 길이는 1 ~ 5 글자 이다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "꽝꽝꽝꽝꽝꽝"})
    void createResultContentsSuccess(String input) {
        assertThatThrownBy(() ->
                        new ResultContent(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}

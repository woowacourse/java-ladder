package domain;

import static domain.Result.MAX_RESULT_LENGTH;
import static domain.Result.MIN_RESULT_LENGTH;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ResultTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "12345"})
    @DisplayName("결과 객체 생성 성공: 성공적으로 도메인이 생성된다.")
    void test_ok_createObject(String value) {
        Result result = new Result(value);
        assertThat(result.getValue()).isEqualTo(value);
    }

    @Test
    @DisplayName("결과 객체 생성 실패: 5글자 초과")
    void test_exception_moreThanFiveLetters() {
        assertThatThrownBy(() -> new Result("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MIN_RESULT_LENGTH + "~" + MAX_RESULT_LENGTH + "자의 결과만 허용합니다.");
    }

    @Test
    @DisplayName("결과 객체 생성 실패: empty")
    void test_exception_empty() {
        assertThatThrownBy(() -> new Result(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MIN_RESULT_LENGTH + "~" + MAX_RESULT_LENGTH + "자의 결과만 허용합니다.");
    }

    @Test
    @DisplayName("결과 객체 생성 실패: null")
    void test_exception_null() {
        assertThatThrownBy(() -> new Result(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("결과에 null을 입력할 수 없습니다.");
    }
}

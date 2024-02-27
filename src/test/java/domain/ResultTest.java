package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ResultTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "12345"})
    @DisplayName("결과 객체 생성 성공: 성공적으로 도메인이 생성된다.")
    void test_ok_createObject(String value) {
        Assertions.assertThatCode(() -> new Result(value))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("결과 객체 생성 실패: 5글자 초과")
    void test_exception_moreThanFiveLetters() {
        Assertions.assertThatThrownBy(() -> new Result("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~5자의 이름만 허용합니다.");
        // TODO: 1, 5 상수화
    }

    @Test
    @DisplayName("결과 객체 생성 실패: null")
    void test_exception_null() {
        Assertions.assertThatThrownBy(() -> new Result(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름에 null을 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("결과 객체 생성 실패: empty")
    void test_exception_empty() {
        Assertions.assertThatThrownBy(() -> new Result(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~5자의 이름만 허용합니다.");
    }
}

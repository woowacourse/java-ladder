package domain;

import exception.InvalidResultNameException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class ResultTest {

    @DisplayName("입력 결과가 조건에 맞는 경우 객체가 생성된다.")
    @Test
    void createSuccess() {
        Result result = new Result("test");
        Assertions.assertEquals(result.getResult(), "test");
    }

    @DisplayName("입력 결과 앞뒤에 공백이 있는 경우 제거하고 생성된다.")
    @Test
    void resultWithBlank() {
        Result result = new Result(" test ");
        Assertions.assertEquals(result.getResult(), "test");
    }

    @DisplayName("입력 결과가 5글자가 넘는 경우 예외를 던진다.")
    @Test
    void resultOver5() {
        Assertions.assertThrows(InvalidResultNameException.class, () -> new Result("abcdef"));
    }

    @DisplayName("입력 결과가 빈문자인 경우 예외를 던진다.")
    @ParameterizedTest
    @NullAndEmptySource
    void resultNullOrEmpty(String input) {
        Assertions.assertThrows(InvalidResultNameException.class, () -> new Result(input));
    }

    @DisplayName("입력 결과가 띄어쓰기로만 이루어진 경우 예외를 던진다.")
    @Test
    void resultBlank() {
        Assertions.assertThrows(InvalidResultNameException.class, () -> new Result("   "));
    }
}

package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class NameTest {

    @Test
    @DisplayName("Name 객체 생성 성공 테스트")
    void createNameTest() {
        Assertions.assertThatNoException().isThrownBy(() -> new Name("ocean"));
    }

    @Test
    @DisplayName("이름 값 길이 제한으로 인한 Name 객체 생성 실패 테스트")
    void limitNameLengthTest() {
        //When
        Throwable result = catchThrowable(() -> new Name("woowacourse"));

        //Then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", " ", "@#$@", "abs@#"})
    @DisplayName("이름은 문자 외에 입력시 Name 객체 생성 실패 테스트.")
    void validateNameHasOnlyCharacters(String inputName) {
        //When
        Throwable result = catchThrowable(() -> new Name(inputName));

        //Then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

}

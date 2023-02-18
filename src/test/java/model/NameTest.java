package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class NameTest {

    @Test
    @DisplayName("Name 객체 생성 성공 테스트")
    void createNameTest() {
        Assertions.assertThatNoException().isThrownBy(() -> new Name("ocean"));
    }

    @ParameterizedTest(name = "이름 값 길이 제한으로 인한 name = {0} Name 객체 생성 실패 테스트")
    @ValueSource(strings = {"oceans", "woowacourse"})
    void limitNameLengthTest(String input) {
        assertThatThrownBy(()-> new Name(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "이름은 문자 외에 name = {0} 입력시 Name 객체 생성 실패 테스트.")
    @NullAndEmptySource
    void validateNameHasOnlyBlank(String inputName) {
        assertThatThrownBy(()-> new Name(inputName)).isInstanceOf(Exception.class);
    }

    @ParameterizedTest(name = "이름은 문자 외에 name = {0} 입력시 Name 객체 생성 실패 테스트.")
    @ValueSource(strings = {"1234", " ", "@#$@", "abs@#"})
    void validateNameHasOnlyCharacters(String inputName) {
        assertThatThrownBy(()-> new Name(inputName)).isInstanceOf(IllegalArgumentException.class);
    }

}

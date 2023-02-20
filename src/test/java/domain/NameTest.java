package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NameTest {

    @DisplayName("이름의 앞 뒤 공백은 무시한다.")
    @ParameterizedTest
    @CsvSource({"'  kong',kong", "'kong  ',kong", "' ko ng ',ko ng", "'    kong   ',kong"})
    void ignoreBlankOfHeadAndTail(String name, String expected) {
        assertThat(new Name(name).getName()).isEqualTo(expected);
    }

    @DisplayName("이름이 1글자에서 5글자 사이가 아니면 예외를 발생시킨다.")
    @ParameterizedTest
    @CsvSource({"''", "kongha", "'  '", "ko   ng"})
    void throwExceptionWhenNameIsInvalid(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1글자에서 5글자 사이이어야 합니다.");
    }

    @DisplayName("이름이 1글자에서 5글자 사이면 예외를 발생시키지 않는다.")
    @ParameterizedTest
    @CsvSource({"odo", "kong"})
    void doesNotThrowExceptionWhenNameIsValid(String name) {
        assertThatCode(() -> new Name(name))
                .doesNotThrowAnyException();
    }
}

package domain;

import exception.InvalidPersonNameException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class PersonTest {

    @DisplayName("사람이름이 조건에 맞을 경우 객체가 생성된다.")
    @Test
    void nameSuccess() {
        Person person = new Person("abcde");
        Assertions.assertThat(person.getName())
                  .isEqualTo("abcde");
    }

    @DisplayName("사람 이름 옆에 공백이 있는 경우 제거하고 저장한다.")
    @Test
    void nameWithBlank() {
        Person person = new Person(" abcde ");
        Assertions.assertThat(person.getName())
                  .isEqualTo("abcde");
    }

    @DisplayName("사람이름이 5글자보다 많을 경우 오류를 던진다.")
    @Test
    void nameOver5() {
        Assertions.assertThatThrownBy(() -> new Person("abcdef"))
                  .isExactlyInstanceOf(InvalidPersonNameException.class);
    }

    @DisplayName("사람이름이 빈문자열일 경우 오류를 던진다.")
    @ParameterizedTest
    @NullAndEmptySource
    void nameNullOrEmpty(String input) {
        Assertions.assertThatThrownBy(() -> new Person(input))
                  .isExactlyInstanceOf(InvalidPersonNameException.class);
    }

    @DisplayName("사람이름이 띄어쓰기로만 이루어진 경우 오류를 던진다.")
    @Test
    void nameBlank() {
        Assertions.assertThatThrownBy(() -> new Person("     "))
                  .isExactlyInstanceOf(InvalidPersonNameException.class);
    }
}

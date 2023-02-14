package domain;

import exception.InvalidPersonNameException;
import exception.NameContainsIdentifierException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PersonTest {

    @DisplayName("사람이름이 조건에 맞을 경우 객체가 생성된다.")
    @Test
    void nameSuccess() {
        try {
            new Person("abcde");
        } catch (IllegalArgumentException exception) {
            Assertions.fail("이름이 조건에 맞을 경우 객체가 제대로 생성되어야 합니다.");
        }
    }

    @DisplayName("사람이름이 5글자보다 많을 경우 오류를 던진다.")
    @Test
    void nameOver5() {
        Assertions.assertThatThrownBy(() -> new Person("abcdef"))
            .isExactlyInstanceOf(InvalidPersonNameException.class);
    }

    @DisplayName("사람이름이 빈문자열일 경우 오류를 던진다.")
    @Test
    void nameNull() {
        Assertions.assertThatThrownBy(() -> new Person(null))
            .isExactlyInstanceOf(InvalidPersonNameException.class);
    }

    @DisplayName("사람이름이 빈문자열일 경우 오류를 던진다.")
    @Test
    void nameEmpty() {
        Assertions.assertThatThrownBy(() -> new Person(""))
            .isExactlyInstanceOf(InvalidPersonNameException.class);
    }

    @DisplayName("사람이름이 띄어쓰기로만 이루어진 경우 오류를 던진다.")
    @Test
    void nameBlank() {
        Assertions.assertThatThrownBy(() -> new Person("     "))
            .isExactlyInstanceOf(InvalidPersonNameException.class);
    }

    @DisplayName("사람이름에 중복 식별자가 들어간 경우 오류를 던진다.")
    @Test
    void nameIdentifier() {
        Assertions.assertThatThrownBy(() -> new Person("ab-cd"))
            .isExactlyInstanceOf(NameContainsIdentifierException.class);
    }
}

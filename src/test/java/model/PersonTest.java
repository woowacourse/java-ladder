package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PersonTest {

    @DisplayName("사람은 이름과 위치를 갖는다.")
    @Test
    void createPerson() {
        String name = "moly";
        Person person = Person.from(name, 0);
        assertThat(person.getName()).isEqualTo(name);
        assertThat(person.getDepth()).isZero();
        assertThat(person.getColumn()).isZero();
    }

    @ParameterizedTest(name = "이름은 최소 1글자 최대 5글자다.")
    @ValueSource(strings = {"", "mollly"})
    void createPersonThrowExceptionWhenInvalidNameLength(String name) {
        assertThatThrownBy(() -> Person.from(name, 0))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 최소 1글자 최대 5글자여야 합니다.");
    }
}
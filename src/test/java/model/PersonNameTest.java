package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PersonNameTest {

    @DisplayName("사람은 이름을 갖는다.")
    @Test
    void createPersonName() {
        String name = "moly";
        PersonName personName = new PersonName(name);
        assertThat(personName.name()).isEqualTo(name);
    }

    @ParameterizedTest(name = "이름은 최소 1글자 최대 5글자다.")
    @ValueSource(strings = {"", "mollly"})
    void createPersonNameThrowExceptionWhenInvalidNameLength(String name) {
        assertThatThrownBy(() -> new PersonName(name))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 최소 1글자 최대 5글자여야 합니다.");
    }
}
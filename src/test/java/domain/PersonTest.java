package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PersonTest {

    @DisplayName("사람이름은 " + Person.MIN_LENGTH + " 이상 " + Person.MAX_LENGTH + " 이하여야 합니다")
    @ParameterizedTest(name = "{0}을 넣으면 예외처리한다.")
    @CsvSource({"''", "여섯글자이름"})
    void personNameLengthTest(String name) {
        assertThatThrownBy(() -> new Person(name))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Person.NAME_LENGTH_FORMAT, Person.MIN_LENGTH, Person.MAX_LENGTH);
    }
}

package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PeopleTest {

    @Test
    @DisplayName("사람은 2명 이상이어야 합니다")
    void peopleCountSuccessTest() {
        assertDoesNotThrow(
            () -> new People(List.of(new Person("hoy"), new Person("hey"))));
    }

    @Test
    @DisplayName("사람이 2명 보다 작으면 예외를 던집니다")
    void peopleCountFailTest() {
        assertThatThrownBy(
            () -> new People(List.of(new Person("hoy"))))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(People.NOT_ENOUGH_PEOPLE_MSG, People.MIN_PERSON_COUNT);
    }

    @Test
    @DisplayName("중복된 사람이름은 올 수 없습니다")
    void duplicateNameTest() {
        assertThatThrownBy(
            () -> new People(List.of(new Person("hoy"), new Person("hoy"))))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(People.DUPLICATE_NAME_MSG);
    }
}

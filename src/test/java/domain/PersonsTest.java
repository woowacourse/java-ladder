package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersonsTest {
    @Test
    @DisplayName("중복된 이름은 안된다")
    void duplicateName() {
        Person baron1 = new Person("baron");
        Person baron2 = new Person("baron");
        Person oing = new Person("oing");

        assertThatThrownBy(() -> new Persons(List.of(baron1, baron2, oing)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복이 아닌 이름은 가능하다")
    void notDuplicateName() {
        Person baron = new Person("baron");
        Person oing = new Person("oing");

        assertDoesNotThrow(() -> new Persons(List.of(baron, oing)));
    }
}

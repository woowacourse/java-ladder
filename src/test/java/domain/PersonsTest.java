package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class PersonsTest {
    @Test
    void persons(){
        Persons persons = new Persons(List.of("1", "2", "3"));

        Assertions.assertThat(persons.getPersonsName())
                .containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("")
    void validateDuplicateName() {
        Assertions.assertThatThrownBy(() -> new Persons(List.of("a", "b", "a")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

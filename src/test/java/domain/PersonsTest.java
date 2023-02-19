package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class PersonsTest {
    @Test
    @DisplayName("Persons 생성 확인")
    void persons(){
        Persons persons = new Persons(List.of("1", "2", "3"));

        Assertions.assertThat(persons.getPersonsName())
                .containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("중복된 닉네임을 입력하면 예외 발생")
    void validateDuplicateName() {
        Assertions.assertThatThrownBy(() -> new Persons(List.of("a", "b", "a")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

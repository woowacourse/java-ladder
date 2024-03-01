package model.people;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PersonTest {

    @DisplayName("사람은 이름을 갖는다.")
    @Test
    void createPerson() {
        String name = "moly";
        Person person = new Person(name);
        assertThat(person.getName()).isEqualTo(name);
    }
}

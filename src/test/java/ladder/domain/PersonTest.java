package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {
    @Test
    void 출력() {
        Person person = new Person(Arrays.asList("pobi", "brown"));
        assertThat(person.toString()).isEqualTo("  pobi brown");
    }
}

package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NameTest {

    @Test
    @DisplayName("정상적인 이름은 예외를 발생하지 않는다")
    void normal_name_doesnt_throw_exception() {
        String nameA = "A";
        Name name = new Name(nameA);

        assertThat(name).isEqualTo(new Name(nameA));
    }

}

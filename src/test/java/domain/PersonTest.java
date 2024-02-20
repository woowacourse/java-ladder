package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonTest {
    @DisplayName("올바른 이름을 가진 사람을 생성한다.")
    @Test
    void createTest() {
        // given
        String name = "pobip";

        // when
        Person person = new Person(name);

        // then
        assertThat(person).extracting("name")
                .isEqualTo(name);
    }

    @Test
    @DisplayName("사람의 이름이 5글자를 넘으면 예외가 발생한다.")
    void nameLengthExceptionTest() {
        // given
        String name = "pobipo";

        // when
        Person person = new Person(name);

        // then
        assertThatThrownBy(() -> new Person(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

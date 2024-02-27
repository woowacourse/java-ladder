package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사람")
public class PersonTest {
    @DisplayName("이름이 올바르면 생성한다.")
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

    @DisplayName("이름이 5글자를 넘으면 예외가 발생한다.")
    @Test
    void nameLengthExceptionTest() {
        assertThatThrownBy(() -> new Person("naknak"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사람 이름의 길이는 5자 이하이어야 합니다.");
    }

    @DisplayName("이름이 비어있거나 공백인 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    void nameBlankExceptionTest(String name) {
        assertThatThrownBy(() -> new Person(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사람 이름의 비어있거나 공백일 수 없습니다.");
    }
}

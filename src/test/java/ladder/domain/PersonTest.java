package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PersonTest {
    @DisplayName("이름이 1~5글자 범위를 벗어나면 예외를 발생한다.")
    @ValueSource(strings = {"", "명오제우스호티배키"})
    @ParameterizedTest
    void PersonTest(String name){
        assertThatThrownBy(() -> new Person(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

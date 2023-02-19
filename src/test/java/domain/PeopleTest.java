package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


class PeopleTest {

    @DisplayName("사용자는 두 명 이상이어야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 10})
    void success(int value) {
        List<String> people = new ArrayList<>();
        for (int i = 0; i < value; i++) {
            people.add("hi" + value);
        }
        assertDoesNotThrow(() -> new People(people));
    }

    @DisplayName("사용자는 두 명 이하이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void fail(int value) {
        List<String> people = new ArrayList<>();
        for (int i = 0; i < value; i++) {
            people.add("hi" + value);
        }
        assertThatThrownBy(() -> new People(people))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사람은 2명 이상이어야 합니다.");
    }
}

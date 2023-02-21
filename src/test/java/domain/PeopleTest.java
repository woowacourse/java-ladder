package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PeopleTest {

    @DisplayName("사람은 두 명 이상이어야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "a1, a2",
            "a1, a2, a3",
            "a1, a2, a3, a4",
    })
    void success_test(String value) {
        assertDoesNotThrow(() -> new People(value));
    }

    @DisplayName("사람은 두 명 이하이면 예외가 발생한다.")
    @Test
    void fail_lowerThanTwo() {
        assertThatThrownBy(() -> new People("a1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사람은 2명 이상이어야 합니다.");
    }

    @DisplayName("중복된 이름이 존재하면 예외가 발생한다.")
    @Test
    void fail_duplicated() {
        assertThatThrownBy(() -> new People("a1,a1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름이 존재합니다.");
    }

    @DisplayName("사람의 이름으로 사다리에서의 시작 열(column)을 찾는다.")
    @ParameterizedTest
    @CsvSource({
            "a1,0",
            "a2,1",
            "a3,2"
    })
    void success_findByName(String name, int index) {
        People people = new People("a1,a2,a3");
        assertThat(people.findPersonColumn(new Person(name))).isEqualTo(index);
    }

    @DisplayName("입력 받은 이름이 존재하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"b1", "b2", "b3"})
    void fail_findByName(String name) {
        People people = new People("a1,a2,a3");
        assertThatThrownBy(() -> people.findPersonColumn(new Person(name)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 사용자는 존재하지 않습니다.");
    }
}

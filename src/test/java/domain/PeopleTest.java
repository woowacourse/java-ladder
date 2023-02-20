package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    void success(String value) {
        assertDoesNotThrow(() -> new People(value));
    }

    @DisplayName("사람은 두 명 이하이면 예외가 발생한다.")
    @Test
    void fail() {
        assertThatThrownBy(() -> new People("a1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사람은 2명 이상이어야 합니다.");
    }
}

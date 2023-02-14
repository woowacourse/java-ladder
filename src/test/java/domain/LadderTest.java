package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @ParameterizedTest(name = "사다리의 높이는 양수만 가능하다")
    @ValueSource(ints = {1, 999})
    void test_ladder_height_success(int height) {
        assertThatNoException().isThrownBy(() -> new Ladder(height, createDefaultPerson()));
    }

    @Test
    @DisplayName("사다리의 높이가 음수면 IllegalArgumentException를 던진다")
    void test_ladder_height_throws() {
        assertThatThrownBy(() -> new Ladder(-1, createDefaultPerson()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private List<Person> createDefaultPerson() {
        return List.of(new Person("aa"));
    }
}

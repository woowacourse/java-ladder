package model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import model.path.RandomPathGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderTest {

    @ParameterizedTest(name = "사다리의 높이는 1 이상이다.")
    @ValueSource(ints = {1, 5})
    void createLadder(int height) {

        People people = People.from(List.of("pobi", "honux", "crong", "jk"));
        assertThatCode(() -> Ladder.from(height, people, new RandomPathGenerator()));
    }

    @Test
    @DisplayName("사다리의 높이는 1 미만은 불가능이다.")
    void createLadderThrowException() {
        int height = 0;
        People people = People.from(List.of("pobi", "honux", "crong", "jk"));
        assertThatThrownBy(() -> Ladder.from(height, people, new RandomPathGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 1 이상이어야 합니다.");
    }

}
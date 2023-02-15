package domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderTest {

    @ParameterizedTest(name = "사다리의 높이는 양수만 가능하다")
    @ValueSource(ints = {1, 999})
    void test_ladder_height_success(int height) {
        assertThatNoException().isThrownBy(() -> new Ladder(createDefaultPerson(), createLines(height)));
    }

    @Test
    @DisplayName("사다리의 높이가 양수가 아니면 IllegalArgumentException를 던진다")
    void test_ladder_height_throws() {
        assertThatThrownBy(() -> new Ladder(createDefaultPerson(), createLines(0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Line들로 Ladder를 생성한다")
    void test_createLadder_with_lines() {
        // given
        List<Line> lines = List.of(
                new Line(List.of(true, false, true)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, true)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, true))
        );

        // when & then
        assertThatNoException().isThrownBy(() -> new Ladder(createDefaultPerson(), lines));
    }

    private List<Line> createLines(int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(List.of(true, false, true)));
        }
        return lines;
    }

    private List<Person> createDefaultPerson() {
        return List.of(new Person("aa"));
    }
}

package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

class LadderTest {

    @DisplayName("사다리의 높이와 사람 수만큼 라인을 생성한다")
    @Test
    void ladder_test(int personCount, int maxHeight) {
        People people = new People(List.of("a", "b", "c"));
        Results results = new Results(List.of("1", "2", "3"));
        Ladder ladder = new RandomLadderGenerator()
                .generate(people, results, maxHeight);
        assertThat(ladder.getWidth()).isEqualTo(personCount - 1);
        assertThat(ladder.getHeight()).isEqualTo(maxHeight);
    }

    @DisplayName("사다리의 높이가 1 이상 10 이하가 아니면 예외가 발생한다.")
    @ParameterizedTest(name = "{index} : 현재 사다리 높이 = {0}")
    @ValueSource(ints = {0, 11})
    void ladder_height_test(int height) {
        People people = new People(List.of("a", "b", "c"));
        Results results = new Results(List.of("1", "2", "3"));
        assertThatThrownBy(() -> new RandomLadderGenerator()
                .generate(people, results, height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 1 이상 10 이하여야 합니다.");
    }
}

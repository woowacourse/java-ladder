package domain.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    private PointGenerator pointGenerator;

    @BeforeEach
    void before() {
        pointGenerator = new RandomPointGenerator();
    }

    @DisplayName("사다리의 최대 높이는 30을 넘을 수 없다.")
    @Test
    void lineSizeNotMoreThan30() {
        Assertions.assertThatThrownBy(() -> Ladder.of(10, 31, pointGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리의 높이는 1이상 30이하여야 합니다.");
    }

    @DisplayName("사다리의 최대 높이는 1보다 작을 수 없다.")
    @ValueSource(ints = {0, -1})
    @ParameterizedTest
    void lineSizeNotLessThan1(int ladderHeight) {
        List<Line> lines = Collections.emptyList();
        Assertions.assertThatThrownBy(() -> Ladder.of(10, ladderHeight, pointGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리의 높이는 1이상 30이하여야 합니다.");
    }

    @DisplayName("사다리의 높이는 1이상 30이하이다.")
    @ValueSource(ints = {1, 10, 30})
    @ParameterizedTest
    void lineSizeTest(int ladderHeight) {
        Ladder ladder = Ladder.of(10, ladderHeight, new RandomPointGenerator());
        assertThat(ladder.getLines().size()).isEqualTo(ladderHeight);
    }

    /**
     * test1 test2 test3
     * |-----|     |
     * |-----|     |
     * |-----|     |
     * |-----|     |
     * |-----|     |
     */
    @DisplayName("사다리를 탄다")
    @Test
    void ride() {
        Ladder ladder = Ladder.of(3, 5, new ExistPointGenerator());
        Map<Integer, Integer> result = ladder.ride(3);

        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(0)).isEqualTo(1);
        assertThat(result.get(1)).isEqualTo(0);
        assertThat(result.get(2)).isEqualTo(2);
    }

}

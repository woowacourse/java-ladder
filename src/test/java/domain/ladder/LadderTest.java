package domain.ladder;

import domain.strategy.TestBridgeMakingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static domain.ladder.Bridge.EMPTY;
import static domain.ladder.Bridge.EXIST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LadderTest {

    @Test
    @DisplayName("한 줄 사다리가 정상적인 크기로 생성되는가")
    void ladder_created_in_correct_size() {
        List<Bridge> bridges = List.of(EXIST, EMPTY, EXIST);
        TestBridgeMakingStrategy strategy = new TestBridgeMakingStrategy(bridges);
        int width = 3, height = 1;

        Ladder ladder = new Ladder(width, height, strategy);
        assertThat(ladder.getWidth()).isEqualTo(width);

        List<Row> rows = ladder.getRows();
        assertThat(rows.size()).isEqualTo(height);
    }

    @Test
    @DisplayName("여러 줄 사다리가 정상적인 크기로 생성되는가")
    void multiple_ladder_created_in_correct_size() {
        List<Bridge> bridges = List.of(EXIST, EMPTY, EXIST, EXIST, EMPTY, EXIST, EXIST, EMPTY, EXIST);
        TestBridgeMakingStrategy strategy = new TestBridgeMakingStrategy(bridges);
        int width = 3, height = 3;

        Ladder ladder = new Ladder(width, height, strategy);
        assertThat(ladder.getWidth()).isEqualTo(width);

        List<Row> rows = ladder.getRows();
        assertThat(rows.size()).isEqualTo(height);
    }

    @Test
    @DisplayName("사다리의 다리가 정상적으로 생성되는가")
    void is_ladder_bridge_creating_correctly() {
        List<Bridge> bridges = List.of(EXIST, EMPTY, EXIST, EXIST, EMPTY, EXIST, EXIST, EMPTY, EXIST);
        TestBridgeMakingStrategy strategy = new TestBridgeMakingStrategy(bridges);
        int width = 3, height = 3;

        Ladder ladder = new Ladder(width, height, strategy);

        for (Row row : ladder.getRows()) {
            List<Bridge> actual = List.of(EXIST, EMPTY, EXIST);
            assertThat(row.getBridges()).isEqualTo(actual);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1", "11,1", "2,0", "2,11"}, delimiter = ',')
    @DisplayName("잘못된 크기의 사다리는 예외를 발생하는가")
    void wrong_size_ladder_throws_exception(int width, int height) {
        assertThatThrownBy(() -> new Ladder(width, height, null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

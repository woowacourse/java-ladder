package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import helper.StubTestDigitsGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class LadderTest {
    private static Ladder ladder;

    @BeforeAll
    static void set() {
        StubTestDigitsGenerator randomDigitsGenerator = new StubTestDigitsGenerator(
                List.of(1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0)
        );
        ladder = new Ladder(4, 3, randomDigitsGenerator);
    }

    private final RandomDigitsGenerator randomDigitsGenerator = new RandomDigitsGenerator();

    @DisplayName("사다리를 생성한다.")
    @Test
    void create_ladder() {
        assertDoesNotThrow(() -> new Ladder(4, 4, randomDigitsGenerator));
    }

    @DisplayName("사다리 높이가 1이상 50이하가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 51})
    void invalid_height(int height) {
        assertThatThrownBy(() -> new Ladder(height, 4, randomDigitsGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 1부터 50까지 입니다.");
    }

    @DisplayName("위치를 받아 오른쪽에 다리가 있으면 건넌다.")
    @Test
    void move_bridge_to_right() {
        Position position = new Position(0);
        Line line = ladder.getLines().get(0);

        ladder.move(line, position);

        assertThat(position.getIndex()).isEqualTo(1);
    }

    @DisplayName("위치를 받아 왼쪽에 다리가 있으면 건넌다.")
    @Test
    void move_bridge_to_left() {
        Position position = new Position(1);
        Line line = ladder.getLines().get(0);

        ladder.move(line, position);

        assertThat(position.getIndex()).isEqualTo(0);
    }

    @DisplayName("위치를 받아 양쪽에 다리가 없는 경우 건너지 않는다.")
    @Test
    void move_bridge_stay() {
        Position position = new Position(1);
        Line line = ladder.getLines().get(2);

        ladder.move(line, position);

        assertThat(position.getIndex()).isEqualTo(1);
    }

}

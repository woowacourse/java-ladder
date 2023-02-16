import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("사다리의 가로와 세로가 제대로 생성되었는지 확인")
    @Test
    void makeLadder() {
        int numberOfWalls = 4;
        Height height = new Height(5);
        Ladder ladder = new Ladder(numberOfWalls, height);

        assertAll(
                () -> assertThat(ladder.getLines().size()).isEqualTo(height.getHeight()),
                () -> assertThat(ladder.getLines().get(0).getLine().size()).isEqualTo(numberOfWalls - 1)
        );
    }
}

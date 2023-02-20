package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.LineGenerator;
import util.LineStatusMaker;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderTest {

    @DisplayName("사다리의 가로와 세로가 제대로 생성되었는지 확인")
    @Test
    void makeLadder() {
        int numberOfWalls = 4;
        Height height = new Height(5);
        LineGenerator lineGenerator = new LineStatusMaker();
        Ladder ladder = new Ladder(numberOfWalls, height, lineGenerator);

        assertAll(
                () -> assertThat(ladder.getLines().getLines().size()).isEqualTo(height.getHeight()),
                () -> assertThat(ladder.getLines().getLines().get(0).getLine().size()).isEqualTo(numberOfWalls - 1)
        );
    }
}

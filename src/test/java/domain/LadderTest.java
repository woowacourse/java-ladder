package domain;

import domain.util.Point;
import domain.util.PointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    void buildLadderTest() {
        LadderHeight height = new LadderHeight(3);
        LadderWidth width = new LadderWidth(3);
        Ladder ladder = Ladder.build(height, width, PointGenerator.getInstance(false));
        assertThat(ladder.getLadderPoints()).containsExactly(
                List.of(
                        Point.PRESENCE, Point.ABSENCE, Point.PRESENCE),
                List.of(
                        Point.PRESENCE, Point.ABSENCE, Point.PRESENCE),
                List.of(
                        Point.PRESENCE, Point.ABSENCE, Point.PRESENCE));
    }

}

package laddergame.domain;

import laddergame.util.LinesGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("라인들")
public class LineTest {
    @Test
    @DisplayName("랜덤값이 Line.Empty이면 다리를 건설하지 않는다.")
    public void buildBridgeTest() {
        //given
        final int personCount = 4;
        final List<Rung> expected = List.of(Rung.EMPTY, Rung.EMPTY, Rung.EMPTY);

        LinesGenerator expectedLinesGenerator = new LinesGenerator() {
            @Override
            public Line generate(int width) {
                return new Line(expected);
            }
        };

        //when
        Line line = expectedLinesGenerator.generate(3);

        //then
        assertEquals(line.getLine(), expected);
    }

    @Test
    @DisplayName("플레이어의 오른쪽에 라인이 있을 경우 오른쪽을 반환한다.")
    void returnRightWhenRightLine() {
        List<Rung> expected = List.of(Rung.BRIDGE, Rung.EMPTY, Rung.EMPTY);
        LinesGenerator expectedLinesGenerator = new LinesGenerator() {
            @Override
            public Line generate(int width) {
                return new Line(expected);
            }
        };
        final Players players = new Players(List.of("name1", "name2", "name3", "name4"));
        final int playerIndex = 0;

        Line line = expectedLinesGenerator.generate(3);
        assertEquals(line.findDirection(playerIndex), Direction.RIGHT);
    }

    @Test
    @DisplayName("플레이어의 왼쪽에 라인이 있을 경우 왼쪽을 반환한다.")
    void returnLeftWhenLeftLine() {
        List<Rung> expected = List.of(Rung.BRIDGE, Rung.EMPTY, Rung.BRIDGE);
        LinesGenerator expectedLinesGenerator = new LinesGenerator() {
            @Override
            public Line generate(int width) {
                return new Line(expected);
            }
        };
        final Players players = new Players(List.of("name1", "name2", "name3", "name4"));
        final int playerIndex = 3;

        Line line = expectedLinesGenerator.generate(3);
        assertEquals(line.findDirection(playerIndex), Direction.LEFT);
    }

    @Test
    @DisplayName("플레이어의 오른쪽과 왼쪽에 모두 라인이 없을 경우 아래로 이동한다.")
    void returnDownWhenEmptyLine() {
        List<Rung> expected = List.of(Rung.EMPTY, Rung.EMPTY, Rung.EMPTY);
        LinesGenerator expectedLinesGenerator = new LinesGenerator() {
            @Override
            public Line generate(int width) {
                return new Line(expected);
            }
        };
        final Players players = new Players(List.of("name1", "name2", "name3", "name4"));
        final int playerIndex = 0;

        Line line = expectedLinesGenerator.generate(3);
        assertEquals(line.findDirection(playerIndex), Direction.DOWN);
    }
}


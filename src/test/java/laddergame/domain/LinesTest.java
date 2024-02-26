package laddergame.domain;

import laddergame.util.LinesGenerator;
import laddergame.util.RandomLinesGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("라인")
public class LinesTest {
    @Test
    @DisplayName("랜덤값이 Line.Empty이면 다리를 건설하지 않는다.")
    public void buildBridgeTest() {
        //given
        final int personCount = 4;
        final List<Line> expected = List.of(Line.EMPTY, Line.EMPTY, Line.EMPTY);

        LinesGenerator expectedLinesGenerator = new LinesGenerator() {
            @Override
            public List<Line> generate(int width) {
                return expected;
            }
        };

        //when
        Lines lines = new Lines(expectedLinesGenerator, personCount -1);

        //then
        assertEquals(lines.getLines(), expected);
    }

    @Test
    @DisplayName("플레이어의 오른쪽에 라인이 있을 경우 오른쪽을 반환한다.")
    void returnRightWhenRightLine() {
        List<Line> expected = List.of(Line.BRIDGE, Line.EMPTY, Line.EMPTY);
        LinesGenerator linesGenerator = new LinesGenerator() {
            @Override
            public List<Line> generate(int width) {
                return expected;
            }
        };
        final Players players = new Players(List.of("name1", "name2", "name3", "name4"));
        final int playerIndex = 0;

        Lines lines = new Lines(linesGenerator, players.getPlayersCount() - 1);
        assertEquals(lines.findDirection(playerIndex), Direction.RIGHT);
    }

    @Test
    @DisplayName("플레이어의 왼쪽에 라인이 있을 경우 왼쪽을 반환한다.")
    void returnLeftWhenLeftLine() {
        List<Line> expected = List.of(Line.BRIDGE, Line.EMPTY, Line.BRIDGE);
        LinesGenerator linesGenerator = new LinesGenerator() {
            @Override
            public List<Line> generate(int width) {
                return expected;
            }
        };
        final Players players = new Players(List.of("name1", "name2", "name3", "name4"));
        final int playerIndex = 3;

        Lines lines = new Lines(linesGenerator, players.getPlayersCount() - 1);
        assertEquals(lines.findDirection(playerIndex), Direction.LEFT);
    }

    @Test
    @DisplayName("플레이어의 오른쪽과 왼쪽에 모두 라인이 없을 경우 아래로 이동한다.")
    void returnDownWhenEmptyLine() {
        List<Line> expected = List.of(Line.EMPTY, Line.EMPTY, Line.EMPTY);
        LinesGenerator linesGenerator = new LinesGenerator() {
            @Override
            public List<Line> generate(int width) {
                return expected;
            }
        };
        final Players players = new Players(List.of("name1", "name2", "name3", "name4"));
        final int playerIndex = 0;

        Lines lines = new Lines(linesGenerator, players.getPlayersCount() - 1);
        assertEquals(lines.findDirection(playerIndex), Direction.DOWN);
    }
}


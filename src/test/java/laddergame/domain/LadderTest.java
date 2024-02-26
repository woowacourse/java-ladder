package laddergame.domain;

import laddergame.util.RandomLinesGenerator;
import laddergame.util.LinesGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("사다리")
public class LadderTest {
    @Test
    @DisplayName("생성에 성공한다.")
    public void createLadderTest() {
        //given
        final Height height = new Height("4");
        final List<String> playersName = List.of("name1", "name2");
        final Players players = new Players(playersName);

        //when
        Ladder ladder = new Ladder(
                new RandomLinesGenerator(),
                players,
                height);

        //then
        assertEquals(ladder.getLines().size(), height.getHeight());
        assertEquals(ladder.getLines().get(0).getLines().size(), playersName.size() - 1);
    }

    @Test
    @DisplayName("사다리 다리 건설 생성에 성공하는지 테스트한다.")
    public void buildLadderBridge() {
        //given
        final Height height = new Height("1");
        final List<String> playersName = List.of("name1", "name2", "name3", "name4");
        final Players players = new Players(playersName);
        final List<Line> expected = List.of(Line.EMPTY, Line.BRIDGE, Line.EMPTY);

        LinesGenerator expectedLinesGenerator = new LinesGenerator() {
            @Override
            public List<Line> generate(int width) {
                return expected;
            }
        };

        //when
        Ladder ladder = new Ladder(expectedLinesGenerator, players, height);

        //then
        assertEquals(expected, ladder.getLines().get(0).getLines());
    }

    @Test
    @DisplayName("플레이어의 오른쪽에 라인이 있을 경우 오른쪽으로 이동한다.")
    void moveRightWhenRightLine() {
        //given
        final Height height = new Height("1");
        final List<String> playersName = List.of("name1", "name2", "name3", "name4");
        final Players players = new Players(playersName);
        final List<Line> expected = List.of(Line.EMPTY, Line.EMPTY, Line.EMPTY);


    }
}

package laddergame.domain;

import laddergame.util.RandomRungGenerator;
import laddergame.util.RungGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
                new LineBuilder(new RandomRungGenerator(), 1),
                height);

        //then
        assertEquals(ladder.getLines().size(), height.getHeight());
        assertEquals(ladder.getLines().get(0).getLine().size(), playersName.size() - 1);
    }

    @Test
    @DisplayName("사다리 다리 건설 생성에 성공하는지 테스트한다.")
    public void buildLadderBridge() {
        //given
        final Height height = new Height("1");
        final List<Rung> expected = List.of(Rung.EMPTY, Rung.EMPTY, Rung.EMPTY);

        RungGenerator expectedRungGenerator = new RungGenerator() {
            @Override
            public Rung generate() {
                return Rung.EMPTY;
            }
        };

        //when
        Ladder ladder = new Ladder(new LineBuilder(expectedRungGenerator, 3), height);

        //then
        assertEquals(expected, ladder.getLines().get(0).getLine());
        assertEquals(3, ladder.getLines().get(0).getLine().size());
        assertEquals(1, ladder.getLines().size());
    }

    @Test
    @DisplayName("세번째 플레이어의 사다리타기 위치가 올바른지 테스트")
    void moveTwoLines() {
        final Height height = new Height("2");
        final List<String> playersName = List.of("name1", "name2", "name3", "name4");
        final Players players = new Players(playersName);

        RungGenerator expectedRungGenerator = new RungGenerator() {
            @Override
            public Rung generate() {
                return Rung.EMPTY;
            }
        };

        Ladder ladder = new Ladder(new LineBuilder(expectedRungGenerator, 3), height);
        ladder.moveToLadderEnd(players.getPlayers().get(2));

        assertTrue(players.getPlayers().get(2).getPosition().equals(new Position(2,2)));
    }
}

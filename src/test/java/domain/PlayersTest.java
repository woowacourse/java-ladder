package domain;

import domain.lines.Lines;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PlayersTest {
    @Test
    @DisplayName("주어진 이름의 개수만큼 참가자를 생성한다.")
    void createPlayers() {
        Names names = new Names(List.of("pobi", "tebah"));
        Players players = new Players(names);

        Assertions.assertEquals(2, players.getPlayers().size());
    }

    @Test
    @DisplayName("주어진 사다리를 이동하여 플레이어의 위치를 결정한다.")
    void playGame() {
        int testHeight = 3;
        int testPersonCount = 2;


        BooleanGenerator booleanGenerator = new FixedBooleanGenerator(true);
        Lines lines = new Lines(testHeight, testPersonCount, booleanGenerator);

        Names names = new Names(List.of("pobi", "tebah"));
        // 사다리 생성 결과
        // pobi  tebah
        //     |-----|
        //     |-----|
        //     |-----|

        Players players = new Players(names);
        players.playGame(lines);
        List<Player> playersAfterPlay = players.getPlayers();

        Assertions.assertAll(
                () -> Assertions.assertEquals(1, playersAfterPlay.get(0).getPosition()),
                () -> Assertions.assertEquals(0, playersAfterPlay.get(1).getPosition())
        );
    }

    @Test
    @DisplayName("주어진 사다리를 이동하여 플레이어의 위치를 결정한다.")
    void playGame2() {
        int testHeight = 3;
        int testPersonCount = 4;


        BooleanGenerator booleanGenerator = new FixedBooleanGenerator(true);
        Lines lines = new Lines(testHeight, testPersonCount, booleanGenerator);
        // 사다리 생성 결과
        // pobi  tebah  honux  crong
        //       |-----|     |-----|
        //       |-----|     |-----|
        //       |-----|     |-----|
        Names names = new Names(List.of("pobi", "tebah", "honux", "crong"));

        Players players = new Players(names);
        players.playGame(lines);
        List<Player> playersAfterPlay = players.getPlayers();

        Assertions.assertAll(
                () -> Assertions.assertEquals(1, playersAfterPlay.get(0).getPosition()),
                () -> Assertions.assertEquals(0, playersAfterPlay.get(1).getPosition()),
                () -> Assertions.assertEquals(3, playersAfterPlay.get(2).getPosition()),
                () -> Assertions.assertEquals(2, playersAfterPlay.get(3).getPosition())

        );
    }

    static class FixedBooleanGenerator implements BooleanGenerator {
        private final Boolean value;

        public FixedBooleanGenerator(Boolean value) {
            this.value = value;
        }

        @Override
        public Boolean generate() {
            return value;
        }
    }
}

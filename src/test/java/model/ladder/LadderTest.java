package model.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import model.bridge.Bridge;
import model.gameResult.GameResult;
import model.line.Line;
import model.line.LineGenerator;
import model.line.RandomLineGenerator;
import model.player.Players;
import model.prize.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {
    Players players = Players.of(List.of("pobi", "lala", "jojo", "gamja"));
    Prizes prizes = Prizes.from(List.of("꽝", "식권" ,"꽝" ,"커피"), players);
    LadderHeight ladderHeight = new LadderHeight(5);

    @DisplayName("사다리는 사다리 높이만큼의 라인을 가짐")
    @Test
    void testSizeOfLadderLines() {
        LineGenerator lineGenerator = new RandomLineGenerator();
        Ladder ladder = Ladder.of(ladderHeight, players, lineGenerator);
        assertThat(ladder.getLines().size())
                .isEqualTo(5);
    }

    @DisplayName("전체 참여자의 실행 결과를 계산한다")
    @Test
    void testSimulateLadder() {
        LineGenerator lineGenerator = new CustomLineGenerator();
        Ladder ladder = Ladder.of(ladderHeight, players, lineGenerator);
        GameResult gameResult = ladder.simulate(players, prizes);
        assertAll(
                () -> assertEquals(gameResult.findPrizeByPlayerName("pobi").getName(), "커피"),
                () -> assertEquals(gameResult.findPrizeByPlayerName("lala").getName(), "꽝"),
                () -> assertEquals(gameResult.findPrizeByPlayerName("jojo").getName(), "식권"),
                () -> assertEquals(gameResult.findPrizeByPlayerName("gamja").getName(), "꽝")
        );
    }

    private static class CustomLineGenerator implements LineGenerator {
        private final List<Line> lines = List.of(
                new Line(List.of(Bridge.UNCONNECTED, Bridge.CONNECTED, Bridge.UNCONNECTED)),
                new Line(List.of(Bridge.CONNECTED, Bridge.UNCONNECTED, Bridge.UNCONNECTED)),
                new Line(List.of(Bridge.UNCONNECTED, Bridge.CONNECTED, Bridge.UNCONNECTED)),
                new Line(List.of(Bridge.CONNECTED, Bridge.UNCONNECTED, Bridge.CONNECTED)),
                new Line(List.of(Bridge.UNCONNECTED, Bridge.UNCONNECTED, Bridge.UNCONNECTED))
        );

        private int count = 0;

        @Override
        public Line generateLine(int width) {
            if (count >= lines.size()) {
                count = 0;
            }
            return lines.get(count++);
        }
    }
}

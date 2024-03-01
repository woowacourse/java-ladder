package model.ladderGame;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static model.ladder.StepStatus.CONNECTED;
import static model.ladder.StepStatus.DISCONNECTED;

import java.util.Arrays;
import java.util.List;
import model.ladder.Ladder;
import model.ladder.Line;
import model.ladder.Step;
import model.ladder.StepStatus;
import model.players.Position;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {
    /*
     *  pobi  honux crong   jk
     *     |-----|     |-----|
     *     |     |-----|     |
     *     |-----|     |-----|
     *     |     |-----|     |
     *     |-----|     |-----|
     *   꽝    5000  꽝    3000
     */
    @DisplayName("지그재그 모양의 사다리를 타서 참여자가 실행 결과와 일치하는 지 확인한다.")
    @Test
    void moveTest() {
        Ladder ladder = new Ladder(List.of(
                createLine(CONNECTED, DISCONNECTED, CONNECTED),
                createLine(DISCONNECTED, CONNECTED, DISCONNECTED),
                createLine(CONNECTED, DISCONNECTED, CONNECTED),
                createLine(DISCONNECTED, CONNECTED, DISCONNECTED),
                createLine(CONNECTED, DISCONNECTED, CONNECTED)
        ));
        LadderGame ladderGame = new LadderGame(ladder);
        Position position = new Position(3);
        int prizeIndex = ladderGame.move(position);
        Assertions.assertThat(prizeIndex).isEqualTo(1);
    }

    private Line createLine(StepStatus... stepStatuses) {
        return Arrays.asList(stepStatuses)
                .stream()
                .map(Step::from)
                .collect(collectingAndThen(toList(), Line::new));
    }
}

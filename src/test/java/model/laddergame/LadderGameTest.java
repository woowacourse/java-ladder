package model.laddergame;

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
import model.players.Players;
import model.prize.Prize;
import model.prize.Prizes;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameTest {
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
        // given
        Ladder ladder = new Ladder(List.of(
                createLine(CONNECTED, DISCONNECTED, CONNECTED),
                createLine(DISCONNECTED, CONNECTED, DISCONNECTED),
                createLine(CONNECTED, DISCONNECTED, CONNECTED),
                createLine(DISCONNECTED, CONNECTED, DISCONNECTED),
                createLine(CONNECTED, DISCONNECTED, CONNECTED)
        ));
        Players players = new Players(List.of("pobi", "honux", "crong", "jk"));
        Prizes prizes = Prizes.of(List.of("꽝", "5000", "꽝", "3000"), 4);
        LadderGame ladderGame = new LadderGame(players, ladder, prizes);

        // when
        Prize prize = ladderGame.move("jk");

        // then
        Assertions.assertThat(prize).isEqualTo(new Prize("5000"));
    }

    private Line createLine(StepStatus... stepStatuses) {
        return Arrays.asList(stepStatuses)
                .stream()
                .map(Step::from)
                .collect(collectingAndThen(toList(), Line::new));
    }
}

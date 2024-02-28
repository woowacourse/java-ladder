package model.ladder;

import model.result.Result;
import model.result.Results;
import model.participant.Participant;
import model.participant.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
    @DisplayName("참가자 별로 결과를 알 수 있다.")
    void participantsResult() {
        Height height = new Height(3);
        Participants participants = new Participants(List.of("pobi", "left", "right", "both"));
        Results results = new Results(List.of("꽝", "5000", "꽝", "3000"));
        Ladder ladder = new Ladder((x, y) -> List.of(
                List.of(true, false, true),
                List.of(false, true, false),
                List.of(true, false, false)), height, participants);
        LadderGame ladderGame = new LadderGame(ladder, participants, results);
        assertThat(ladderGame.matchResult(new Participant("pobi"))).isEqualTo(new Result("꽝"));

    }

//                |-----|     |-----|
//                |     |-----|     |
//                |-----|     |     |

    @Test
    @DisplayName("전체 참가자들의 결과를 알 수 있다.")
    void allParticipantsResult() {
        Height height = new Height(3);
        Participants participants = new Participants(List.of("pobi", "left", "right", "both"));
        Results results = new Results(List.of("꽝", "5000", "꽝", "3000"));
        Ladder ladder = new Ladder((x, y) -> List.of(
                List.of(true, false, true),
                List.of(false, true, false),
                List.of(true, false, false)), height, participants);
        LadderGame ladderGame = new LadderGame(ladder, participants, results);
        assertThat(ladderGame.matchAllResults()).isEqualTo(Map.of(
                new Participant("pobi"), new Result("꽝"),
                new Participant("left"), new Result("5000"),
                new Participant("right"), new Result("3000"),
                new Participant("both"), new Result("꽝")));
    }
}

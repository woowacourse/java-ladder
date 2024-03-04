package model.ladder;

import model.participant.Participant;
import model.participant.Participants;
import model.result.ParticipantsResult;
import model.result.Result;
import model.result.Results;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

//                |-----|     |-----|
//                |     |-----|     |
//                |-----|     |     |

    @Test
    @DisplayName("참가자들의 결과를 알 수 있다.")
    void participantsResult() {
        Height height = new Height(3);
        Participants participants = new Participants(List.of("pobi", "left", "right", "both"));
        Results results = new Results(List.of("꽝", "5000", "꽝", "3000"), participants.size());
        Ladder ladder = new Ladder((x, y) -> List.of(
                List.of(true, false, true),
                List.of(false, true, false),
                List.of(true, false, false)), height, participants);
        LadderGame ladderGame = new LadderGame(ladder, participants, results);
        assertThat(ladderGame.getParticipantsResult()).isEqualTo(new ParticipantsResult(Map.of(
                new Participant("pobi"), new Result("꽝"),
                new Participant("left"), new Result("5000"),
                new Participant("right"), new Result("3000"),
                new Participant("both"), new Result("꽝"))));
    }
}

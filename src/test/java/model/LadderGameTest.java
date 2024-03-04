package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {

    @DisplayName("참가자와 결과 크기가 다르면 예외가 발생한다.")
    @Test
    void differentParticipantsAndResultsSize() {
        Participants participants = new Participants(List.of(
                new Participant(new Name("0"), new Position(0)),
                new Participant(new Name("1"), new Position(1)),
                new Participant(new Name("2"), new Position(2)),
                new Participant(new Name("3"), new Position(3)),
                new Participant(new Name("4"), new Position(4))));
        Results results = new Results(List.of(new Result(new Position(0), "꽝")));
        Ladder ladder = new Ladder(List.of(
                new LadderRow(() -> true, 4),
                new LadderRow(() -> true, 4)));
        Assertions.assertThatThrownBy(() -> new LadderGame(participants, ladder, results))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참가자로부터 게임 결과를 얻는다.")
    @Test
    void findResult() {
        LadderGame ladderGame = createLadderGame();
        Result zeroResult = ladderGame.findParticipantResult(new Participant(new Name("0"), new Position(0)));
        Result oneResult = ladderGame.findParticipantResult(new Participant(new Name("1"), new Position(1)));
        Result secondResult = ladderGame.findParticipantResult(new Participant(new Name("2"), new Position(2)));
        Result thirdResult = ladderGame.findParticipantResult(new Participant(new Name("3"), new Position(3)));
        Result forthResult = ladderGame.findParticipantResult(new Participant(new Name("4"), new Position(4)));

        assertAll(() -> assertThat(zeroResult).isEqualTo(new Result(new Position(0), "꽝")),
                () -> assertThat(oneResult).isEqualTo(new Result(new Position(1), "5000")),
                () -> assertThat(secondResult).isEqualTo(new Result(new Position(2), "꽝")),
                () -> assertThat(thirdResult).isEqualTo(new Result(new Position(3), "3000")),
                () -> assertThat(forthResult).isEqualTo(new Result(new Position(4), "꽝")));
    }

    private static LadderGame createLadderGame() {
        Ladder ladder = new Ladder(List.of(
                new LadderRow(() -> true, 4),
                new LadderRow(() -> true, 4)));
        Participants participants = new Participants(List.of(
                new Participant(new Name("0"), new Position(0)),
                new Participant(new Name("1"), new Position(1)),
                new Participant(new Name("2"), new Position(2)),
                new Participant(new Name("3"), new Position(3)),
                new Participant(new Name("4"), new Position(4))));
        Results results = createResults();
        return new LadderGame(participants, ladder, results);
    }


    private static Results createResults() {
        return new Results(List.of(new Result(new Position(0), "꽝"),
                new Result(new Position(1), "5000"),
                new Result(new Position(2), "꽝"),
                new Result(new Position(3), "3000"),
                new Result(new Position(4), "꽝")));
    }
}

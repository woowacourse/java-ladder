package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {

    @DisplayName("참가자와 결과 크기가 다르면 예외가 발생한다.")
    @Test
    void differentParticipantsAndResultsSize() {
        Participants participants = new Participants(List.of("0", "1", "2", "3", "4"));
        Map<Position, Result> result = new LinkedHashMap<>();
        result.put(new Position(0), new Result("꽝"));
        Ladder ladder = new Ladder(List.of(
                new LadderRow(List.of(true, false, false, true)),
                new LadderRow(List.of(true, false, true, false))));
        Assertions.assertThatThrownBy(() -> new LadderGame(participants, ladder, result))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참가자로부터 게임 결과를 얻는다.")
    @Test
    void findResult() {
        LadderGame ladderGame = createLadderGame();
        Result zeroResult = ladderGame.findParticipantResult(new Name("0"));
        Result oneResult = ladderGame.findParticipantResult(new Name("1"));
        Result secondResult = ladderGame.findParticipantResult(new Name("2"));
        Result thirdResult = ladderGame.findParticipantResult(new Name("3"));
        Result forthResult = ladderGame.findParticipantResult(new Name("4"));

        assertAll(() -> assertThat(zeroResult).isEqualTo(new Result("꽝")),
                () -> assertThat(oneResult).isEqualTo(new Result("5000")),
                () -> assertThat(secondResult).isEqualTo(new Result("꽝")),
                () -> assertThat(thirdResult).isEqualTo(new Result("3000")),
                () -> assertThat(forthResult).isEqualTo(new Result("꽝")));
    }

    @DisplayName("모든 참가자의 게임 결과를 얻는다.")
    @Test
    void findAllResults() {
        LadderGame ladderGame = createLadderGame();
        Map<Name, Result> results = ladderGame.findAllParticipantResults();
        Assertions.assertThat(results).isEqualTo(
                Map.of(new Name("0"), new Result("꽝"),
                        new Name("1"), new Result("5000"),
                        new Name("2"), new Result("꽝"),
                        new Name("3"), new Result("3000"),
                        new Name("4"), new Result("꽝")));
    }

    private static LadderGame createLadderGame() {
        Ladder ladder = new Ladder(List.of(
                new LadderRow(List.of(true, false, false, true)),
                new LadderRow(List.of(true, false, true, false))));
        Participants participants = new Participants(List.of("0", "1", "2", "3", "4"));
        Map<Position, Result> result = createResults();
        return new LadderGame(participants, ladder, result);
    }

    private static Map<Position, Result> createResults() {
        Map<Position, Result> result = new LinkedHashMap<>();
        result.put(new Position(0), new Result("꽝"));
        result.put(new Position(1), new Result("5000"));
        result.put(new Position(2), new Result("꽝"));
        result.put(new Position(3), new Result("꽝"));
        result.put(new Position(4), new Result("3000"));
        return result;
    }
}

package domain;

import domain.ladder.Ladder;
import domain.ladder.LadderHeight;
import domain.ladder.LadderPrizes;
import domain.ladder.LadderSize;
import domain.ladder.LineWeight;
import domain.participants.Participants;
import exception.ladder.GameEndException;
import exception.participants.NullNameException;
import java.util.List;
import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultTest {

    private GameResult gameResult;

    @BeforeEach
    void makeGameResult() {
        List<String> names = List.of("ash", "split", "ako", "mako", "heero", "bever");
        List<String> prizes = List.of("1000", "2000", "3000", "4000", "5000", "6000");

        LadderPrizes ladderPrizes = LadderPrizes.valueOf(String.join(",", prizes), prizes.size());
        Participants participants = makeParticipants(names);
        String lineHeight = "1";
        Ladder ladder = makeLadder(names, lineHeight);

        LadderGame ladderGame = LadderGame.builder()
            .addParticipants(participants)
            .addLadder(ladder)
            .addLadderPrizes(ladderPrizes)
            .build();
        gameResult = GameResult.from(ladderGame);
    }

    Participants makeParticipants(List<String> names) {
        return Participants.of(String.join(",", names));
    }

    LadderSize makeLadderSize(String height, int weight) {
        return new LadderSize(new LadderHeight(height), new LineWeight(weight));
    }

    Ladder makeLadder(List<String> names, String ladderHeight) {
        TestBooleanGenerator testGenerator = new TestBooleanGenerator();
        testGenerator.addOrderedValues(List.of(true, false, false, true, false));
        return Ladder.valueOf(makeLadderSize(ladderHeight, names.size() - 1), testGenerator);
    }

    @DisplayName("게임 실행 결과를 생성한다.")
    @Test
    void getGameResult() {
        //given
        List<String> names = List.of("ash", "split", "ako", "mako", "heero", "bever");
        List<String> expected = List.of("2000", "1000", "3000", "4000", "6000", "5000");
        //when then
        Assertions.assertThat(gameResult.getResults()).hasSize(6);
        IntStream.range(0, expected.size())
            .forEach((index) -> Assertions.assertThat(gameResult.getResultByName(names.get(index)).getName())
                .isEqualTo(expected.get(index)));
    }

    @DisplayName("존재하지 않는 참가자의 결과를 조회시 오류를 던진다.")
    @Test
    void noParticipant() {
        //given
        //when, then
        Assertions.assertThatThrownBy(() -> gameResult.getResultByName("none"))
            .isExactlyInstanceOf(NullNameException.class);
    }

    @DisplayName("exit 을 조회시 오류를 던진다.")
    @Test
    void findExit() {
        //given
        //when, then
        Assertions.assertThatThrownBy(() -> gameResult.getResultByName("exit"))
            .isExactlyInstanceOf(GameEndException.class);
    }
}

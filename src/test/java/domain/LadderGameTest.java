package domain;

import controller.LadderGameController;
import domain.ladder.Ladder;
import domain.ladder.LadderHeight;
import domain.ladder.LadderPrize;
import domain.ladder.LadderPrizes;
import domain.ladder.LadderSize;
import domain.ladder.LineWeight;
import domain.participants.Participants;
import exception.ladder.GameEndReservedWordException;
import exception.participants.NullNameException;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

class LadderGameTest {

    @DisplayName("게임 실행 결과를 생성한다.")
    @Test
    void getGameResult() {
        //given
        List<String> names = List.of("ash", "split", "ako");
        List<String> prizes = List.of("1000", "2000", "3000");
        String height = "1";
        List<Boolean> generateValues = List.of(true, false, false);
        List<LadderPrize> expected = List.of(
            new LadderPrize("2000"), new LadderPrize("1000"), new LadderPrize("3000"));
        //when
        GameResult gameResult = makeResult(names, prizes, generateValues, height);
        //then
        Assertions.assertThat(gameResult.getAllResults()).hasSize(3);
        Assertions.assertThat(gameResult.getAllResults().values()).containsExactlyElementsOf(expected);
    }

    @DisplayName("잘못된 입력으로 조회 할 떄")
    @TestFactory
    Stream<DynamicTest> invalidNameForResult() {
        //given
        List<String> names = List.of("split", "jamie");
        List<String> prizes = List.of("1000", "2000");
        List<Boolean> generateValues = List.of(true);
        String height = "1";
        GameResult gameResult = makeResult(names, prizes, generateValues, height);
        return Stream.of(
            DynamicTest.dynamicTest("존재하지 않는 참가자로 조회", () ->
                Assertions.assertThatThrownBy(() -> gameResult.getPrizeByName("none"))
                    .isExactlyInstanceOf(NullNameException.class)),
            DynamicTest.dynamicTest("게임 종료 예약어로 참가자 조회", () ->
                Assertions.assertThatThrownBy(() -> gameResult.getPrizeByName(LadderGameController.EXIT_RESERVED_WORD))
                    .isExactlyInstanceOf(GameEndReservedWordException.class))
        );
    }

    private GameResult makeResult(List<String> names, List<String> prizes, List<Boolean> generateValues,
        String height) {
        Participants participants = makeParticipants(names);
        LadderPrizes ladderPrizes = makeLadderPrizes(prizes);
        LadderSize ladderSize = makeLadderSize(height, participants.getCount() - 1);
        Ladder ladder = Ladder.valueOf(ladderSize, setTestGenerator(generateValues));
        LadderGame ladderGame = LadderGame.builder()
            .addParticipants(participants)
            .addLadderPrizes(ladderPrizes)
            .addLadder(ladder)
            .build();
        return ladderGame.generateResults();
    }

    private Participants makeParticipants(List<String> names) {
        return Participants.of(String.join(",", names));
    }

    private LadderPrizes makeLadderPrizes(List<String> prizes) {
        return LadderPrizes.valueOf(String.join(",", prizes), prizes.size());
    }

    private LadderSize makeLadderSize(String height, int weight) {
        return new LadderSize(new LadderHeight(height), new LineWeight(weight));
    }

    private TestBooleanGenerator setTestGenerator(List<Boolean> generateValues) {
        TestBooleanGenerator testBooleanGenerator = new TestBooleanGenerator();
        testBooleanGenerator.addOrderedValues(generateValues);
        return testBooleanGenerator;
    }
}

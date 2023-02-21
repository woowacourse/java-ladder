package domain;

import java.util.Map;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class GameResultTest {

    @DisplayName("게임 실행 결과를 ")
    @TestFactory
    Stream<DynamicTest> makeGameResult() {
        Participants participants = new Participants("ash,split,ako,mako,heero,bever");
        LadderResults ladderResults = new LadderResults("1000,2000,3000,4000,5000,6000");
        return Stream.of(
            DynamicTest.dynamicTest("true만 반환하는 제네레이터를 사용할 때", () -> {
                Ladder ladder = new Ladder("3", 5, () -> true);
                GameResult gameResult = new GameResult(ladder, participants, ladderResults);
                Assertions.assertThat(gameResult.getResult()).containsAllEntriesOf(Map.of(
                    "ash", "2000",
                    "split", "1000",
                    "ako", "4000",
                    "mako", "3000",
                    "heero", "6000",
                    "bever", "5000"
                ));
            }),
            DynamicTest.dynamicTest("false만 반환하는 제네레이터를 사용할 때", () -> {
                Ladder ladder = new Ladder("3", 5, () -> false);
                GameResult gameResult = new GameResult(ladder, participants, ladderResults);
                Assertions.assertThat(gameResult.getResult()).containsAllEntriesOf(Map.of(
                    "ash", "1000",
                    "split", "2000",
                    "ako", "3000",
                    "mako", "4000",
                    "heero", "5000",
                    "bever", "6000"
                ));
            })
        );
    }
}

package model;

import static org.assertj.core.api.Assertions.assertThat;

import dto.GameResult;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
class LadderGameTest {

    private LadderGame ladderGame;

    @BeforeEach
    void beforeEach() {
        List<String> collectNames = List.of("a", "b");
        Names names = Names.of(collectNames);
        List<Path> passable = List.of(Path.UN_PASSABLE, Path.UN_PASSABLE);
        Line line = new Line(passable);
        Ladder ladder = new Ladder(List.of(line));
        List<LadderResult> results = List.of(new LadderResult("1"), new LadderResult("2"));
        LadderResults ladderResults = LadderResults.of(results, 2);

        ladderGame = LadderGame.of(names, ladder, ladderResults);
    }

    @Nested
    class findGameResult_메소드_테스트 {

        @ParameterizedTest(name = "참가자의_이름을_입력하면_결과를_반환한다")
        @CsvSource(value = {"a:1", "b:2"}, delimiter = ':')
        void onlyOneTest(String name, String expected) {
            List<GameResult> gameResults = ladderGame.findGameResult(name);

            GameResult gameResult = gameResults.get(0);

            assertThat(gameResults.size()).isSameAs(1);
            assertThat(gameResult.getName()).isEqualTo(name);
            assertThat(gameResult.getLadderResult()).isEqualTo(expected);
        }

        @Test
        void all_커맨드를_입력하면_메소드는_전체_참가자의_게임_결과를_반환한다() {
            List<GameResult> totalGameResult = ladderGame.findGameResult("all");

            GameResult participantA = totalGameResult.get(0);
            GameResult participantB = totalGameResult.get(1);

            assertThat(totalGameResult.size()).isSameAs(2);
            assertThat(participantA.getName()).isEqualTo("a");
            assertThat(participantA.getLadderResult()).isEqualTo("1");
            assertThat(participantB.getName()).isEqualTo("b");
            assertThat(participantB.getLadderResult()).isEqualTo("2");
        }
    }
}

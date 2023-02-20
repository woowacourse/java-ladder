package model;


import static org.assertj.core.api.Assertions.assertThat;

import dto.GameResult;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
class LadderGameTest {

    private LadderGame ladderGame;

    @BeforeEach
    void beforeEach() {
        List<Name> nameCollection = List.of(new Name("a"), new Name("b"));
        Names names = new Names(nameCollection);
        List<Path> passable = List.of(Path.UN_PASSABLE, Path.UN_PASSABLE);
        Line line = new Line(passable);
        Ladder ladder = new Ladder(List.of(line));
        List<LadderResult> results = List.of(new LadderResult("1"), new LadderResult("2"));
        LadderResults ladderResults = LadderResults.of(results, 2);

        ladderGame = LadderGame.of(names, ladder, ladderResults);
    }

    @ParameterizedTest
    @CsvSource(value = {"a:1", "b:2"}, delimiter = ':')
    void getGameResultOfName_메소드는_참가자의_이름을_입력하면_결과를_반환한다(String name, String expected) {
        String actual = ladderGame.getGameResultOfName(name);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getTotalGameResult_메소드는_전체_참가자의_게임_결과를_반환한다() {
        List<GameResult> totalGameResult = ladderGame.getTotalGameResult();

        GameResult participantA = totalGameResult.get(0);
        GameResult participantB = totalGameResult.get(1);

        assertThat(participantA.getName()).isEqualTo("a");
        assertThat(participantA.getLadderResult()).isEqualTo("1");
        assertThat(participantB.getName()).isEqualTo("b");
        assertThat(participantB.getLadderResult()).isEqualTo("2");
    }
}

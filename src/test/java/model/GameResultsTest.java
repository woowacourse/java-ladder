package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import helper.StubPassGenerator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import strategy.PassGenerator;

@DisplayNameGeneration(ReplaceUnderscores.class)
class GameResultsTest {

    private GameResults gameResults;

    @BeforeEach
    void beforeEach() {
        List<String> collectNames = List.of("a", "b");
        Names names = Names.of(collectNames);
        PassGenerator falseFalseGenerator = new StubPassGenerator(List.of(Boolean.FALSE, Boolean.FALSE));
        Height height = new Height(5);
        Ladder ladder = Ladder.of(falseFalseGenerator, height, 2);
        List<LadderResult> results = List.of(new LadderResult("1"), new LadderResult("2"));
        LadderResults ladderResults = LadderResults.of(results, 2);

        gameResults = GameResults.of(names, ladder, ladderResults);
    }

    @Nested
    class findGameResultByName_메소드_테스트 {

        @Test
        void 전달한_name과_일치하는_GameResult가_있다면_일치하는_GameResult를_반환한다() {
            assertThatThrownBy(() -> gameResults.findGameResultByName("c"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("존재하지 않는 참가자 이름입니다.");
        }

        @ParameterizedTest(name = "전달한 name과 일치하는 GameResult가 없다면 예외가 발생한다")
        @CsvSource(value = {"a:1", "b:2"}, delimiter = ':')
        void failTest(String name, String expected) {
            GameResult actual = gameResults.findGameResultByName(name);

            assertThat(actual.getName()).isEqualTo(name);
            assertThat(actual.getLadderResult()).isEqualTo(expected);
        }
    }
}

package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import dto.GameResultDto;
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
class LadderGameTest {

    private LadderGame ladderGame = new LadderGame();

    @Nested
    class 상태_검증_테스트 {

        private LadderGame ladderGame = new LadderGame();

        @Test
        void initParticipantsNames_메소드는_이름을_입력하면_Names를_초기화한다() {
            List<String> nameInfo = List.of("a", "b");

            assertThatCode(() -> ladderGame.initParticipantsNames(nameInfo)).doesNotThrowAnyException();
        }

        @Test
        void initLadderResults_메소드는_names를_초기화하지_않았다면_예외가_발생한다() {
            List<String> ladderResultsInfo = List.of("1", "2");

            assertThatThrownBy(() -> ladderGame.initLadderResults(ladderResultsInfo))
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessageContaining("참가자가 등록되지 않았습니다.");
        }

        @Test
        void initLadderResults_메소드는_names를_초기화했다면_ladderResults를_초기화한다() {
            List<String> nameInfo = List.of("a", "b");
            ladderGame.initParticipantsNames(nameInfo);
            List<String> ladderResultsInfo = List.of("1", "2");

            assertThatCode(() -> ladderGame.initLadderResults(ladderResultsInfo)).doesNotThrowAnyException();
        }

        @Test
        void initLadder_메소드는_names를_초기화하지_않았다면_예외가_발생한다() {
            StubPassGenerator generator = new StubPassGenerator(List.of(Boolean.FALSE, Boolean.TRUE));

            assertThatThrownBy(() -> ladderGame.initLadder(generator, 5))
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessageContaining("참가자가 등록되지 않았습니다.");
        }

        @Test
        void initLadder_메소드는_names를_초기화했다면_ladder를_초기화한다() {
            List<String> nameInfo = List.of("a", "b");
            ladderGame.initParticipantsNames(nameInfo);
            List<String> ladderResultsInfo = List.of("1", "2");
            ladderGame.initLadderResults(ladderResultsInfo);
            StubPassGenerator falseTrueGenerator = new StubPassGenerator(List.of(Boolean.FALSE, Boolean.TRUE));

            assertThatCode(() -> ladderGame.initLadder(falseTrueGenerator, 5)).doesNotThrowAnyException();
        }

        @Test
        void play_메소드는_names를_초기화하지_않았다면_예외가_발생한다() {
            assertThatThrownBy(() -> ladderGame.play())
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessageContaining("참가자가 등록되지 않았습니다.");
        }

        @Test
        void play_메소드는_ladderResults를_초기화하지_않았다면_예외가_발생한다() {
            List<String> nameInfo = List.of("a", "b");
            ladderGame.initParticipantsNames(nameInfo);

            assertThatThrownBy(() -> ladderGame.play())
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessageContaining("사다리 실행 결과가 등록되지 않았습니다.");
        }

        @Test
        void play_메소드는_ladder를_초기화하지_않았다면_예외가_발생한다() {
            List<String> nameInfo = List.of("a", "b");
            ladderGame.initParticipantsNames(nameInfo);
            List<String> resultsInfo = List.of("1", "2");
            ladderGame.initLadderResults(resultsInfo);

            assertThatThrownBy(() -> ladderGame.play())
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessageContaining("사다리가 생성되지 않았습니다.");
        }

        @Test
        void play_메소드는_names_ladderResults_ladder를_초기화했다면_사다리_게임을_실행하고_gameResults를_초기화한다() {
            List<String> nameInfo = List.of("a", "b");
            ladderGame.initParticipantsNames(nameInfo);
            List<String> resultsInfo = List.of("1", "2");
            ladderGame.initLadderResults(resultsInfo);
            PassGenerator generator = new StubPassGenerator(List.of(Boolean.FALSE, Boolean.FALSE));
            ladderGame.initLadder(generator, 5);

            assertThatCode(() -> ladderGame.play()).doesNotThrowAnyException();
        }

        @Test
        void findGameResult_메소드는_gameResults를_초기화하지_않았다면_예외가_발생한다() {
            List<String> nameInfo = List.of("a", "b");
            ladderGame.initParticipantsNames(nameInfo);
            List<String> resultsInfo = List.of("1", "2");
            ladderGame.initLadderResults(resultsInfo);
            PassGenerator generator = new StubPassGenerator(List.of(Boolean.FALSE, Boolean.FALSE));
            ladderGame.initLadder(generator, 5);

            assertThatThrownBy(() -> ladderGame.findGameResult("a"))
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessageContaining("사다리 게임을 진행하지 않았습니다.");
        }
    }

    @Nested
    class findGameResult_메소드_테스트 {

        private LadderGame ladderGame = new LadderGame();

        @BeforeEach
        void beforeEach() {
            List<String> nameInfo = List.of("a", "b");
            ladderGame.initParticipantsNames(nameInfo);
            List<String> resultsInfo = List.of("1", "2");
            ladderGame.initLadderResults(resultsInfo);
            PassGenerator falseFalseGenerator = new StubPassGenerator(List.of(Boolean.FALSE, Boolean.FALSE));
            ladderGame.initLadder(falseFalseGenerator, 5);
            ladderGame.play();
        }

        @ParameterizedTest(name = "참가자의_이름을_입력하면_결과를_반환한다")
        @CsvSource(value = {"a:1", "b:2"}, delimiter = ':')
        void onlyOneTest(String name, String expected) {
            List<GameResultDto> gameResults = ladderGame.findGameResult(name);

            GameResultDto gameResult = gameResults.get(0);

            assertThat(gameResults.size()).isSameAs(1);
            assertThat(gameResult.getParticipantName()).isEqualTo(name);
            assertThat(gameResult.getLadderResult()).isEqualTo(expected);
        }

        @Test
        void all_커맨드를_입력하면_메소드는_전체_참가자의_게임_결과를_반환한다() {
            List<GameResultDto> totalGameResult = ladderGame.findGameResult("all");

            GameResultDto participantA = totalGameResult.get(0);
            GameResultDto participantB = totalGameResult.get(1);

            assertThat(totalGameResult.size()).isSameAs(2);
            assertThat(participantA.getParticipantName()).isEqualTo("a");
            assertThat(participantA.getLadderResult()).isEqualTo("1");
            assertThat(participantB.getParticipantName()).isEqualTo("b");
            assertThat(participantB.getLadderResult()).isEqualTo("2");
        }
    }
}

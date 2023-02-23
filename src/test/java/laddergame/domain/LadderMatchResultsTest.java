package laddergame.domain;

import laddergame.fixture.GameResultsFixture;
import laddergame.fixture.NamesFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리 매칭 결과")
class LadderMatchResultsTest {
    @DisplayName("매칭될 이름들이 null일 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenNamesIsNull() {
        final Names names = null;
        final GameResults gameResults = GameResultsFixture.createResultsSize3();

        assertThatThrownBy(() -> new LadderMatchResults(names, gameResults))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("매칭될 결과들이 null일 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenGameResultsIsNull() {
        final Names names = NamesFixture.getNamesSize3();
        final GameResults gameResults = null;

        assertThatThrownBy(() -> new LadderMatchResults(names, gameResults))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("첫 번째 매칭 결과를 가져온다.")
    @RepeatedTest(10)
    void getFirstMatchResult() {
        final Names names = NamesFixture.getNamesSize3();
        final GameResults gameResults = GameResultsFixture.createResultsSize3();
        final LadderMatchResults matchResults = new LadderMatchResults(names, gameResults);
        final Result findResult = matchResults.getFirstMatchResult();
        final Result expectedResult = gameResults.getResults().get(0);

        assertThat(findResult)
                .usingRecursiveComparison()
                .isEqualTo(expectedResult);
    }

    @DisplayName("사다리 매칭 결과를 가져온다.")
    @ParameterizedTest
    @MethodSource("matchResultsParameterDummy")
    void getMatchResults(final Names names, final GameResults gameResults) {
        final LadderMatchResults matchResults = new LadderMatchResults(names, gameResults);
        final Map<Name, Result> findMatchResults = matchResults.getMatchResults();
        final int expectedSize = names.getSize();

        assertThat(findMatchResults).hasSize(expectedSize);
    }

    @DisplayName("사다리 매칭 결과 개수를 가져온다.")
    @ParameterizedTest
    @MethodSource("matchResultsParameterDummy")
    void getSize(final Names names, final GameResults gameResults) {
        final LadderMatchResults matchResults = new LadderMatchResults(names, gameResults);
        final int matchResultsSize = matchResults.getSize();
        final int expectedSize = names.getSize();

        assertThat(matchResultsSize).isEqualTo(expectedSize);
    }

    static Stream<Arguments> matchResultsParameterDummy() {
        return Stream.of(
                Arguments.arguments(NamesFixture.getNamesSize2(), GameResultsFixture.createResultsSize2()),
                Arguments.arguments(NamesFixture.getNamesSize3(), GameResultsFixture.createResultsSize3())
        );
    }
}
package laddergame.domain;

import laddergame.fixture.NamesFixture;
import laddergame.fixture.PositionFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultsTest {
    @DisplayName("결과 목록이 null일 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenResultsIsNull() {
        final List<String> results = null;

        assertThatThrownBy(() -> new Results(results, NamesFixture.getNamesSize3()));
    }

    @DisplayName("결과 목록이 비어있을 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenResultsIsEmpty() {
        final List<String> results = List.of();

        assertThatThrownBy(() -> new Results(results, NamesFixture.getNamesSize3()));
    }

    @DisplayName("결과 목록이 2개 미만일 경우 예외가 발생한다.")
    @ParameterizedTest(name = "results = {0}")
    @MethodSource("wrongResultsParameterDummy")
    void throwExceptionWhenResultsHasSizeLessThan2(final List<String> inputResults) {
        assertThatThrownBy(() -> new Results(inputResults, NamesFixture.getNamesSize3()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("결과 목록을 가져온다.")
    @ParameterizedTest(name = "results = {0}, names = {1}")
    @MethodSource("resultParametersDummy")
    void getResults(final List<String> inputResults, final Names names) {
        final Results results = new Results(inputResults, names);
        final List<String> findResults = results.getResults();

        assertThat(findResults).containsExactlyElementsOf(inputResults);
    }

    @DisplayName("결과 목록에서 위치를 통해서 결과를 가져올 수 있다.")
    @Test
    void findResultByPosition() {
        final Results results = new Results(List.of("hello", "helo", "heeeee"), NamesFixture.getNamesSize3());
        final Result findResult = results.findResultByPosition(PositionFixture.createPositionZero());

        assertThat(findResult.getValue()).isEqualTo("hello");
    }

    @DisplayName("결과 목록 개수가 이름 목록 개수와 같지 않을 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenResultsAndNamesHasNotSameSize() {
        assertThatThrownBy(() -> new Results(List.of("hello", "helo"), NamesFixture.getNamesSize3()));
    }

    static Stream<Arguments> resultParametersDummy() {
        return Stream.of(
                Arguments.arguments(List.of("hello", "helo"), NamesFixture.getNamesSize2()),
                Arguments.arguments(List.of("hello", "helo", "hi"), NamesFixture.getNamesSize3())
        );
    }

    static Stream<Arguments> wrongResultsParameterDummy() {
        return Stream.of(
                Arguments.arguments(List.of("hello")),
                Arguments.arguments(List.of("helo")),
                Arguments.arguments(List.of("hel"))
        );
    }
}

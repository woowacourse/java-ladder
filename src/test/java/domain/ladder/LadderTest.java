package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.player.Name;
import domain.player.Players;
import domain.result.Result;
import domain.result.Results;
import dto.RowPatternDto;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    Ladder createDummyLadder(List<String> names, List<String> results, int height) {
        Players ladderPlayers = new Players(names);
        Results ladderResults = new Results(results);
        LadderHeight ladderHeight = new LadderHeight(height);

        return new Ladder(ladderPlayers, ladderResults, ladderHeight);
    }

    @Test
    @DisplayName("사다리가 올바르게 생성되었을 때, 각 사람이 매핑되는 결과가 올바르게 반환된다.")
    void validCreationTest() {
        // given
        List<String> names = List.of("aru", "pobi", "woowa", "hello");
        List<String> results = List.of("1000", "2000", "3000", "4000");
        Ladder ladder = createDummyLadder(names, results, 3);
        // when, then
        List<String> actual = names.stream()
                .map(ladder::getResultByName)
                .map(Result::rawResult)
                .toList();
        assertThat(actual).containsExactlyElementsOf(results);
    }

    @Test
    @DisplayName("사다리를 항상 놓는 전략으로 생성했을 때, 올바른 매핑 결과를 반환한다.")
    void validMappingIndicesWhenAlwaysPlacing() {
        // given
        List<String> names = List.of("aru", "pobi", "woowa", "hello");
        List<String> results = List.of("1000", "2000", "3000", "4000");
        List<String> expected = List.of("2000", "1000", "4000", "3000");
        Ladder ladder = createDummyLadder(names, results, 3);
        // when
        ladder.drawLines(() -> true);
        // then
        List<String> actual = names.stream()
                .map(ladder::getResultByName)
                .map(Result::rawResult)
                .toList();
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    @DisplayName("사다리를 항상 놓는 전략으로 생성했을 때, 올바른 행 별 패턴을 반환한다.")
    void dtoConversionTest() {
        // given
        List<String> names = List.of("aru", "pobi", "woowa", "hello");
        List<String> results = List.of("1000", "2000", "3000", "4000");
        Ladder ladder = createDummyLadder(names, results, 1);
        List<Boolean> expected = List.of(true, false, true);
        // when
        ladder.drawLines(() -> true);
        // then
        List<RowPatternDto> ladderPatterns = ladder.getLadderPatterns();
        List<Boolean> actual = ladderPatterns.get(0).rowPattern();
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    @DisplayName("상하가 서로 대칭이 아닌 경우에도 올바르게 매핑 정보를 반환한다.")
    void asymmetricLadderConversionTest() {
        // given
        Iterator<Boolean> it = Stream.of(true, false, false, true).iterator();
        List<String> names = List.of("aru", "pobi", "woowa");
        List<String> results = List.of("1000", "2000", "3000");
        Ladder ladder = createDummyLadder(names, results, 2);
        // when
        ladder.drawLines(it::next);
        Map<Name, Result> playerResults = ladder.getAllPlayerResults();
        // then
        Map<Name, Result> expected = Map.of(
                new Name("aru"), new Result("3000"),
                new Name("pobi"), new Result("1000"),
                new Name("woowa"), new Result("2000")
        );
        assertThat(playerResults).containsAllEntriesOf(expected);
    }

    @Test
    @DisplayName("사람의 수와 결과의 수가 일치하지 않는 경우, 예외를 발생한다.")
    void sizeMismatchCreationTest() {
        // given
        Players players = new Players(List.of("aru", "pobi", "woowa"));
        Results results = new Results(List.of("1000", "2000"));
        LadderHeight height = new LadderHeight(1);
        // when, then
        assertThatThrownBy(() -> new Ladder(players, results, height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사람의 수와 결과의 개수가 일치하지 않습니다.");
    }
}

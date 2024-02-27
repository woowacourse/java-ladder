package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import dto.RowPatternDto;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    Ladder createDummyLadder(int lineCount, int height) {
        LadderHeight ladderHeight = new LadderHeight(height);
        return new Ladder(lineCount, lineCount, ladderHeight);
    }

    @Test
    @DisplayName("사다리가 올바르게 생성되었을 때, 각 사람이 매핑되는 결과가 올바르게 반환된다.")
    void validCreationTest() {
        // given
        Ladder ladder = createDummyLadder(5, 3);
        // when
        Map<Integer, Integer> actual = ladder.getMappedIndices();
        Map<Integer, Integer> expected = Map.of(
                0, 0,
                1, 1,
                2, 2,
                3, 3,
                4, 4
        );
        // then
        assertThat(actual).containsExactlyInAnyOrderEntriesOf(expected);
    }

    @Test
    @DisplayName("사다리를 항상 놓는 전략으로 생성했을 때, 올바른 매핑 결과를 반환한다.")
    void validMappingIndicesWhenAlwaysPlacing() {
        // given
        Ladder ladder = createDummyLadder(4, 3);
        Map<Integer, Integer> expected = Map.of(
                0, 1,
                1, 0,
                2, 3,
                3, 2
        );
        // when
        ladder.drawLines(() -> true);
        // then
        Map<Integer, Integer> actual = ladder.getMappedIndices();
        assertThat(actual).containsExactlyInAnyOrderEntriesOf(expected);
    }

    @Test
    @DisplayName("사다리를 항상 놓는 전략으로 생성했을 때, 올바른 행 별 패턴을 반환한다.")
    void dtoConversionTest() {
        // given
        Ladder ladder = createDummyLadder(4, 1);
        List<Boolean> expected = List.of(true, false, true);
        // when
        ladder.drawLines(() -> true);
        List<RowPatternDto> ladderPatterns = ladder.getLadderPatterns();
        List<Boolean> actual = ladderPatterns.get(0).rowPattern();
        // then
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    @DisplayName("상하가 서로 대칭이 아닌 경우에도 올바르게 매핑 정보를 반환한다.")
    void asymmetricLadderConversionTest() {
        // given
        Iterator<Boolean> it = Stream.of(true, false, false, true).iterator();
        Ladder ladder = createDummyLadder(3, 2);
        Map<Integer, Integer> expected = Map.of(
                0, 2,
                1, 0,
                2, 1
        );
        // when
        ladder.drawLines(it::next);
        Map<Integer, Integer> actual = ladder.getMappedIndices();
        // then
        assertThat(actual).containsExactlyInAnyOrderEntriesOf(expected);
    }

    @Test
    @DisplayName("사람의 수와 결과의 수가 일치하지 않는 경우, 예외를 발생한다.")
    void sizeMismatchCreationTest() {
        // given
        LadderHeight height = new LadderHeight(1);
        // when, then
        assertThatThrownBy(() -> new Ladder(3, 2, height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사람의 수와 결과의 개수가 일치하지 않습니다.");
    }
}

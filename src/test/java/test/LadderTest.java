package test;

import ladder.domain.Ladder;
import ladder.domain.RowLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import test.linegenerator.AllFalseLineGenerator;
import test.linegenerator.AlternativeLineGenerator;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @Test
    @DisplayName("사용자가 입력한 높이만큼의 사다리가 생성된다")
    void ladderHeightTest() {
        int height = 10;
        int peopleNumber = 10;
        List<RowLine> rowLines = new Ladder(height, peopleNumber).getRowLines();
        assertThat(rowLines).hasSize(height);
    }

    @DisplayName("사다리의 높이가 1이상 100이하가 아니면 사다리를 생성할 수 없다")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 101})
    void ladderExceedHeightTest(int height) {
        assertThatThrownBy(() -> new Ladder(height, 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // |     |     |     |     |
    // |     |     |     |     |
    @DisplayName("사다리 생성 테스트 : 가로선이 없는 경우")
    @Test
    void makeLadderTest() {
        Ladder testLadder = new Ladder(2, 5, new AllFalseLineGenerator());
        Set<Boolean> connectionElement = testLadder.getRowLines()
                .stream()
                .map(RowLine::getConnection)
                .flatMap(List::stream)
                .collect(Collectors.toSet());

        assertThat(connectionElement).containsExactly(Boolean.FALSE);
    }

    // |     |     |     |     |
    // |     |     |     |     |
    @DisplayName("사다리 결과 테스트 : 가로선이 없는 경우")
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4})
    void noLineLadderResultTest(int lineNumber) {
        Ladder testLadder = new Ladder(2, 5, new AllFalseLineGenerator());
        assertThat(testLadder.getResultOf(lineNumber)).isEqualTo(lineNumber);
    }

    // |-----|     |-----|     |
    // |-----|     |-----|     |
    @DisplayName("사다리 결과 테스트 : 가로선이 홀수번째에 있는 경우")
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4})
    void alternativeLadderResultTest(int lineNumber) {
        Ladder testLadder = new Ladder(2, 5, new AlternativeLineGenerator());
        assertThat(testLadder.getResultOf(lineNumber)).isEqualTo(lineNumber);
    }
}

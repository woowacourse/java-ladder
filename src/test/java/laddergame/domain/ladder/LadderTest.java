package laddergame.domain.ladder;

import laddergame.domain.ladder.Connection;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.RowLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import laddergame.domain.connectiongenerator.AllFalseConnectionGenerator;

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

    @DisplayName("사다리 생성 테스트 : 가로선이 없는 경우")
    @Test
    void makeLadderTest() {
        Ladder testLadder = new Ladder(3, 5, new AllFalseConnectionGenerator());
        Set<Connection> connectionElement = testLadder.getRowLines()
                .stream()
                .map(RowLine::getConnections)
                .flatMap(List::stream)
                .collect(Collectors.toSet());

        assertThat(connectionElement).containsExactly(Connection.NOTCONNECTED);
    }
}

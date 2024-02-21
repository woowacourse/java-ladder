import ladder.domain.Ladder;
import ladder.domain.RowLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

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

}

package ladder.domain;

import ladder.domain.ladder.Ladder;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;


class LadderTest {

    @ParameterizedTest
    @CsvSource({"0,1", "1,0"})
    @DisplayName("사다리의 가로나 세로 값은 1 이상 이어야 한다")
    void testCreate(int width, int height) {
        assertThatThrownBy(() -> new Ladder(width, height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("가로 및 높이는 1 이상이어야 한다.");
    }

    @Test
    @DisplayName("다른 인덱스에서 시작한 사다리는 서로 다른 결과를 얻는다")
    void testValidGetResult() {
        final int width = 3, height = 1;
        final Ladder ladder = new Ladder(width, height);

        final Map<Integer, Integer> resultIndex = ladder.getAllMatch();

        int match0 = resultIndex.get(0);
        int match1 = resultIndex.get(1);
        int match2 = resultIndex.get(2);
        assertTrue(match0 != match1 && match0 != match2 && match1 != match2);
    }
}

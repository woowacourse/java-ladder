package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class LadderTest {

    Ladder ladder;

    @BeforeEach
    void setUp() {
        ladder = new Ladder(new Height("3"), new Weight(3), () -> true);
    }

    @DisplayName("높이와 참가자의 수가 조건에 맞는 경우 사다리를 생성한다.")
    @Test
    void createSuccess() {
        Assertions.assertThat(ladder.getLines()).hasSize(3);
    }

    @DisplayName("참가자 수에서 1을 뺀 만큼의 라인을 가진사다리를 만든다.")
    @Test
    void generateMap() {
        List<Line> lines = ladder.getLines();
        Assertions.assertThat(lines).hasSize(3);
        Assertions.assertThat(lines.get(0).getStatus())
                  .containsExactly(LineStatus.CONNECTED, LineStatus.DISCONNECTED);
        Assertions.assertThat(lines.get(1).getStatus())
                  .containsExactly(LineStatus.CONNECTED, LineStatus.DISCONNECTED);
        Assertions.assertThat(lines.get(2).getStatus())
                  .containsExactly(LineStatus.CONNECTED, LineStatus.DISCONNECTED);
    }

    @DisplayName("각 인덱스에 따른 결과를 반환한다")
    @ParameterizedTest
    @CsvSource({"0, 1", "1, 0", "2, 2"})
    void getResultIndex(int index, int expect) {
        Assertions.assertThat(ladder.getResultIndex(index)).isEqualTo(expect);
    }
}

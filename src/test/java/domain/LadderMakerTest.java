package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LadderMakerTest {

    LadderMaker ladderMaker = new LadderMaker();

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 50, 100})
    @DisplayName("높이가 1이상 100이하이면 사다리가 생성된다.")
    void createLine_Success(int height) {
        assertThatNoException().isThrownBy(() -> ladderMaker.make(5, height));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 101, 150, 1000})
    @DisplayName("높이가 1미만 100초과이면 예외가 발생한다.")
    void createLine_Fail(int height) {
        assertThatThrownBy(() -> ladderMaker.make(5, height))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 10, 100})
    @DisplayName("사다리 높이 만큼 Line을 생성한다.")
    void createLinesWithHeight(int height) {
        Ladder ladder = new Ladder(ladderMaker.make(5, height));
        assertThat(ladder.getLines().size()).isEqualTo(height);
    }
}

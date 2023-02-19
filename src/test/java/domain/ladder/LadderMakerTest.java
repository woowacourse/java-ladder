package domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.ErrorMessage;

import static org.assertj.core.api.Assertions.*;

public class LadderMakerTest {

    LadderMaker ladderMaker = new LadderMaker();

    @ParameterizedTest
    @ValueSource(ints = {1, 100})
    @DisplayName("높이가 1이상 100이하이면 사다리가 생성된다.")
    void createLine_Success(int height) {
        assertThatNoException().isThrownBy(() -> ladderMaker.make(5, height));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 101})
    @DisplayName("높이가 1미만 100초과이면 예외가 발생한다.")
    void createLine_Fail(int height) {
        assertThatThrownBy(() -> ladderMaker.make(5, height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.HEIGHT_ERROR.getMessage());
    }

    @Test
    @DisplayName("사다리 높이 만큼 Line을 생성한다.")
    void createLinesWithHeight() {
        Ladder ladder = new Ladder(ladderMaker.make(5, 10));
        assertThat(ladder.getLines().size()).isEqualTo(10);
    }
}

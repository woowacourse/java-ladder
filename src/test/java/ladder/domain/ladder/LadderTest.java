package ladder.domain.ladder;

import ladder.domain.rule.BlockGenerator;
import ladder.domain.rule.RandomBlockGenerator;
import ladder.exception.LadderLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    private final BlockGenerator blockGenerator = new RandomBlockGenerator();

    @Test
    @DisplayName("사다리 길이는 <플레이어 수 - 1> 이상이 아닌 경우 예외가 발생한다.")
    void 사다리_길이_제약조건_테스트() {
        int playerNumber = 5;
        int height = 3;

        assertThatThrownBy(() -> new Ladder(playerNumber, height, blockGenerator))
                .isInstanceOf(LadderLengthException.class);
    }

    @Test
    void 사다리_생성_테스트() {
        int playerNumber = 5;
        int height = 5;

        assertThatCode(() -> new Ladder(playerNumber, height, blockGenerator))
                .doesNotThrowAnyException();
    }
}

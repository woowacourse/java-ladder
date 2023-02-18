package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("사다리 생성 시, 유저는 2~10명만 가능하기 때문에,")
class LadderGeneratorTest {
    LadderGenerator ladderGenerator = LadderGenerator.getInstance();
    @ParameterizedTest
    @DisplayName("사다리 각 층의 너비는 1~9개로 만들어지지 않으면 예외가 발생한다.")
    @ValueSource(ints = {0,10})
    void generateLadderFailTest(int width) {
        assertThatThrownBy(() -> ladderGenerator.generateLadder(width))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("사다리 각 층의 너비는 1~9개로 만들어지면 정상적으로 사다리 각 층이 생성된다..")
    @ValueSource(ints = {1,9})
    void generateLadderSuccessTest(int width) {
        assertThatCode(() -> ladderGenerator.generateLadder(width))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("생성된 사다리의 너비는 parameter로 넘어간 정수와 같아야 한다.")
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9})
    void generateLadderTest(int width) {
        List<Bridge> ladder = ladderGenerator.generateLadder(width);
        assertThat(ladder.size()).isEqualTo(width);
    }
}

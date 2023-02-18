package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리 생성 시, 유저는 2~10명만 가능하기 때문에,")
class LadderGeneratorTest {

    @ParameterizedTest
    @DisplayName("사다리 각 층의 다리는 1~9개로 만들어지지 않으면 예외가 발생한다.")
    @ValueSource(ints = {0,10})
    void generateLadderFailTest(int bridgeCount) {
        LadderGenerator ladderGenerator = LadderGenerator.getInstance();
        assertThatThrownBy(() -> ladderGenerator.generateLadder(bridgeCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("사다리 각 층의 다리는 1~9개로 만들어지면 정상적으로 사다리 각 층이 생성된다..")
    @ValueSource(ints = {1,9})
    void generateLadderSuccessTest(int bridgeCount) {
        LadderGenerator ladderGenerator = LadderGenerator.getInstance();
        assertThatCode(() -> ladderGenerator.generateLadder(bridgeCount))
                .doesNotThrowAnyException();
    }
}

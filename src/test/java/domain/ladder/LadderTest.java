package domain.ladder;

import domain.generator.RandomBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 50, 100})
    @DisplayName("높이가 1이상 100이하이면 사다리가 생성된다.")
    void createLine_Success(int height) {
        assertThatNoException().isThrownBy(() -> new Ladder(5, height, new RandomBooleanGenerator()));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 101, 150, 1000})
    @DisplayName("높이가 1미만 100초과이면 예외가 발생한다.")
    void createLine_Fail(int height) {
        assertThatThrownBy(() -> new Ladder(5, height, new RandomBooleanGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리 높이는 1이상 100이하의 자연수만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 10, 100})
    @DisplayName("사다리 높이 만큼 Line을 생성한다.")
    void createLinesWithHeight(int height) {
        Ladder ladder = new Ladder(5, height, new RandomBooleanGenerator());
        assertThat(ladder.getLines().size()).isEqualTo(height);
    }
}

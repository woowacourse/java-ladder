package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderTest {

    @DisplayName("사다리의 높이만큼 라인을 생성한다")
    @ParameterizedTest(name = "{index} : 사다리 높이 {0}만큼 라인을 생성한다 ")
    @ValueSource(ints = {3, 4, 5, 6})
    void ladder_height_test(int height) {
        Ladder ladder = new Ladder(4, height, new RandomBridgeGenerator());
        assertThat(ladder.getHeight()).isEqualTo(height);
    }

    @DisplayName("사람 {수 -1} 길이의 사다리의 폭을 생성한다")
    @ParameterizedTest(name = "{index} : 사다리의 폭의 길이는 {0}-1 이다 ")
    @ValueSource(ints = {3, 4, 5, 6})
    void ladder_width_test(int personCount) {
        Ladder ladder = new Ladder(personCount, 3, new RandomBridgeGenerator());
        assertThat(ladder.getWidth()).isEqualTo(personCount - 1);

    }
}

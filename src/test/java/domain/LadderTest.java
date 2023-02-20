package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LadderTest {

    @DisplayName("사다리의 높이와 사람 수만큼 라인을 생성한다")
    @ParameterizedTest
    @CsvSource({
            "2, 1",
            "2, 10",
            "3, 5",
    })
    void hello(int personCount, int maxHeight) {
        StringBuilder names = new StringBuilder();
        for (int i = 0; i < personCount; i++) {
            names.append("hi").append(i).append(",");
        }
        Ladder ladder = new Ladder(new People(names.toString()), maxHeight, new RandomGenerateStrategy());
        assertThat(ladder.getWidth()).isEqualTo(personCount - 1);
        assertThat(ladder.getHeight()).isEqualTo(maxHeight);
    }

    @DisplayName("사다리의 높이가 1 이상 10 이하가 아니면 예외가 발생한다.")
    @ParameterizedTest(name = "{index} : 현재 사다리 높이 = {0}")
    @ValueSource(ints = {-1, 0, 11})
    void ladder_invalid_test(int height) {
        assertThatThrownBy(() -> new Ladder(new People("hello,world"), height, new RandomGenerateStrategy()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 1 이상 10 이하여야 합니다");
    }

}

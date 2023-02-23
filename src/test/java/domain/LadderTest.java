package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

class LadderTest {

    @DisplayName("사다리의 높이와 사람 수만큼 라인을 생성한다")
    @ParameterizedTest
    @CsvSource({
            "2, 1",
            "2, 10",
            "3, 5",
    })
    void ladder_test(int personCount, int maxHeight) {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < personCount; i++) {
            names.add("hi" + i);
        }
        Ladder ladder = new RandomLadderGenerator()
                .generate(new People(names), maxHeight);
        assertThat(ladder.getWidth()).isEqualTo(personCount - 1);
        assertThat(ladder.getHeight()).isEqualTo(maxHeight);
    }

    @DisplayName("사다리의 높이가 1 이상 10 이하가 아니면 예외가 발생한다.")
    @ParameterizedTest(name = "{index} : 현재 사다리 높이 = {0}")
    @ValueSource(ints = {0, 11})
    void ladder_height_test(int height) {
        assertThatThrownBy(() -> new RandomLadderGenerator().generate(new People(List.of("hello", "world")), height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 1 이상 10 이하여야 합니다.");
    }
}

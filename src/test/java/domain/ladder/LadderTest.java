package domain.ladder;

import domain.ladder.Ladder;
import domain.booleangenerator.RandomBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    @DisplayName("사다리의 높이는 자연수로 입력되어야 한다.")
    @ParameterizedTest
    @CsvSource({"0", "-1"})
    void createLadderTest(int height) {
        assertThatThrownBy(() -> new Ladder(height, 4, new RandomBooleanGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 자연수이어야 합니다.");
    }

    @DisplayName("사다리의 높이는 열의 개수 이상이어야 한다.")
    @ParameterizedTest
    @CsvSource(value = {"3:4", "8:14"}, delimiter = ':')
    void createLadderTest2(int height, int width) {
        assertThatThrownBy(() -> new Ladder(height, width, new RandomBooleanGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 열의 개수 이상이어야 합니다.");
    }

    @DisplayName("사다리 높이가 열의 개수 이상인 경우에는 사다리를 생성한다.")
    @ParameterizedTest
    @CsvSource(value = {"4:3", "5:5"}, delimiter = ':')
    void createLadderTest3(int height, int width) {
        assertThatCode(() -> new Ladder(height, width, new RandomBooleanGenerator()))
                .doesNotThrowAnyException();
    }
}

package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.numbergenerator.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LadderTest {

    @DisplayName("사다리의 높이는 자연수로 입력되어야 한다.")
    @ParameterizedTest
    @CsvSource({"0", "-1"})
    void createLadderTest(int height) {
        assertThatThrownBy(() -> new Ladder(height, 4, new RandomNumberGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 자연수이어야 합니다.");
    }

    @DisplayName("사다리 높이는 참가자 수 이상이어야한다.")
    @ParameterizedTest
    @CsvSource(value = {"3:4", "8:14"}, delimiter = ':')
    void createLadderTest2(int height, int personCount) {
        assertThatThrownBy(() -> new Ladder(height, personCount, new RandomNumberGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 참가자 수 이상이어야 합니다.");
    }

    @DisplayName("사다리 높이가 정상적으로 입력되면 사다리를 생성한다.")
    @ParameterizedTest
    @CsvSource(value = {"4:3", "14:5"}, delimiter = ':')
    void createLadderTest3(int height, int personCount) {
        assertThatCode(() -> new Ladder(height, personCount, new RandomNumberGenerator()))
                .doesNotThrowAnyException();
    }
}

package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import helper.StubTestDigitsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class LadderTest {
    private final RandomDigitsGenerator randomDigitsGenerator = new RandomDigitsGenerator();


    @DisplayName("사다리를 생성한다.")
    @Test
    void create_ladder() {
        assertDoesNotThrow(() -> new Ladder(4, 4, randomDigitsGenerator));
    }

    @DisplayName("사다리 높이가 1이상 50이하가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 51})
    void invalid_height(int height) {
        assertThatThrownBy(() -> new Ladder(height, 4, randomDigitsGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 1부터 50까지 입니다.");
    }

    @DisplayName("지정한 위치에 다리의 존재 여부 확인하기")
    @ParameterizedTest
    @CsvSource({"1,1,true", "1,2,false", "2,1,true", "2,2,false", "3,3,true", "4,1,false"})
    void check_exist(int height, int width, boolean result) {
        StubTestDigitsGenerator myRandomDigitsGenerator = new StubTestDigitsGenerator(
                List.of(1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0)
        );
        Ladder ladder = new Ladder(4, 3, myRandomDigitsGenerator);
        assertThat(ladder.isExist(height, width)).isEqualTo(result);
    }

}

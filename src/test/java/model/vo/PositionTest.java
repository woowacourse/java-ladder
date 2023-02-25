package model.vo;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * 플레이어 위치를 Wrapping하는 클래스.
 * 원시타입 데이터의 getter는 테스트하지 않는다.
 */
public class PositionTest {
    @Test
    @DisplayName("Position 객체 생성 성공 테스트")
    void createPositionTest() {
        assertThatNoException().isThrownBy(() -> new Position(1));
    }

    @ParameterizedTest
    @CsvSource(value = {"0:false", "1:true"}, delimiter = ':')
    @DisplayName("주어진 위치 값과의 동일 여부를 알 수 있는 기능 테스트")
    void isSamePositionValueTest(int testCase, boolean expected) {
        //given
        Position existingPosition = new Position(1);
        Position comparePosition = new Position(testCase);

        //when
        boolean result = existingPosition.isSame(comparePosition);

        //then
        assertThat(result).isEqualTo(expected);
    }
}

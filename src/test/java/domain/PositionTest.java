package domain;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PositionTest {

    private Position position;

    @BeforeEach
    void setUp() {
        position = Position.from(3);
    }

    @DisplayName("사용자의 위치는 입력되는 수가 1만큼 작으면 감소하고 동일한 경우 증가, 이 외에는 변하지 않는다.")
    @ParameterizedTest
    @CsvSource(value = {"1:3", "4:3", "3:4", "5:3"}, delimiter = ':')
    void moveTest(int number, int expected) {
        position.move(number);
        assertEquals(expected, position.getPosition());
    }

    @DisplayName("입력된 수 중에 현재 위치와 동일하거나 1만큼 작은 수가 있으면 그 수를 반환한다.")
    @Test
    void findConnectionNumberTest() {
        List<Integer> numbers = List.of(0, 3, 5);
        assertEquals(3,
            position.findConnectionNumber(numbers));
    }

}
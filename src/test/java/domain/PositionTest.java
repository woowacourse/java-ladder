package domain;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PositionTest {

    private Position position;

    @BeforeEach
    void setUp() {
        position = new Position(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:3", "4:3", "3:4", "5:3"}, delimiter = ':')
    void move(int number, int expected) {
        position.move(number);
        assertEquals(expected, position.getPosition());
    }

    @Test
    void findConnectionNumberTest() {
        List<Integer> numbers = List.of(0, 3, 5);
        assertEquals(3,
            position.findConnectionNumber(numbers));
    }

}
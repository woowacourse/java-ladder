package domain;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PositionTest {

    private Position position;

    @BeforeEach
    void setUp() {
        position = new Position(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:false", "3:true", "2:true", "0:false", "4:false"}, delimiter = ':')
    void checkConnectionTest(int number, boolean expected) {
        assertEquals(expected, position.checkConnection(number));
    }

}
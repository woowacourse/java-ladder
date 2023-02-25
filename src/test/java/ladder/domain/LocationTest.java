package ladder.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LocationTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 5})
    @DisplayName("초기 위치를 입력 받아 Location을 생성한다")
    void shouldDoesNotThrowExceptionWhenCreate(int input) {
        assertDoesNotThrow(() -> new Location(input));
    }
}
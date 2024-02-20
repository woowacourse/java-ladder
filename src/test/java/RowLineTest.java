import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RowLineTest {
    @DisplayName("peopleNumber가 1이상 100이하가 아닐 때, RowLine 객체를 생성할 수 없다")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 101})
    void peopleNumbersInvalidInput(int peopleNumber) {
        assertThrows(IllegalArgumentException.class
                , () -> {
                    new RowLine(peopleNumber, new RandomLineGenerator());
                });
    }

    @DisplayName("peopleNumber가 1이상 100이하일 때, RowLine 객체를 생성할 수 있다")
    @Test
    void peopleNumbersValidInput() {
        assertDoesNotThrow(
                () -> {
                    new RowLine(100, new RandomLineGenerator());
                });
    }

    @DisplayName("연속된 가로선이 있는 RowLine 객체는 생성되지 않는다")
    @Test
    void successiveRowLineTest() {
        assertThrows(IllegalArgumentException.class
                , () -> {
                    new RowLine(5, new SuccessiveLineGenerator());
                });
    }

    @DisplayName("연속된 가로선이 없는 RowLine 객체는 생성할 수 있다")
    @Test
    void unsuccessiveRowLineTest() {
        assertDoesNotThrow(
                () -> {
                    new RowLine(5, new RandomLineGenerator());
                });
    }
}

import ladder.domain.RandomLineGenerator;
import ladder.domain.RowLine;
import ladder.domain.SuccessiveLineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RowLineTest {
    @DisplayName("peopleNumber가 1이상 100이하가 아닐 때, domain.RowLine 객체를 생성할 수 없다")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 101})
    void peopleNumbersInvalidInput(int peopleNumber) {
        assertThrows(IllegalArgumentException.class
                , () -> {
                    new RowLine(peopleNumber, new RandomLineGenerator());
                });
    }

    @DisplayName("peopleNumber가 1이상 100이하일 때, domain.RowLine 객체를 생성할 수 있다")
    @Test
    void peopleNumbersValidInput() {
        assertDoesNotThrow(
                () -> {
                    new RowLine(100, new RandomLineGenerator());
                });
    }

    @DisplayName("연속된 가로선이 있는 domain.RowLine 객체는 생성되지 않는다")
    @Test
    void successiveRowLineTest() {
        assertThrows(IllegalArgumentException.class
                , () -> {
                    new RowLine(5, new SuccessiveLineGenerator());
                });
    }

    @DisplayName("연속된 가로선이 없는 domain.RowLine 객체는 생성할 수 있다")
    @Test
    void unsuccessiveRowLineTest() {
        assertDoesNotThrow(
                () -> {
                    new RowLine(5, new RandomLineGenerator());
                });
    }

    @DisplayName("참여자의 수가 n일 때, RowLine의 connection 길이는 n-1이다")
    @ParameterizedTest
    @ValueSource(ints = {100, 1, 2})
    void rowLineConnectionSizeTest(int n) {
        List<Boolean> connection = new RowLine(n, new RandomLineGenerator()).getConnection();
        assertThat(connection).hasSize(n - 1);
    }

    //TODO 테스트케이스 추가 : 전략패턴(allFalseLineGenerator)
}

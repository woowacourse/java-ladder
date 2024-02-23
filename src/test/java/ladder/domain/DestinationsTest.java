package ladder.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DestinationsTest {
    @DisplayName("사용자 수와 다르면 예외를 던진다.")
    @Test
    void throwExceptionWhenAmountNotSameWithUserNames() {
        List<String> destinations = List.of("꽝", "5000", "꽝", "3000");
        int userCount = 5;

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Destinations.of(destinations, userCount))
                .withMessage("실행 결과 수는 사용자 수와 같아야 합니다.");
    }
}

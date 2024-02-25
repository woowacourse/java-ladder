package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Destinations.of(destinations, userCount))
                .withMessage("실행 결과 수는 사용자 수와 같아야 합니다.");
    }

    @DisplayName("List<String>으로 전달 받은 destinations들을 List<Destination>으로 반환한다.")
    @Test
    void makeStringToDestination() {
        List<String> destinations = List.of("꽝", "5000");

        Assertions.assertThat(Destinations.of(destinations, 2).getDestinations())
                .containsExactly("꽝", "5000");
    }
}

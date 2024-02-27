package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatIndexOutOfBoundsException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

        assertThat(Destinations.of(destinations, 2).getDestinations())
                .containsExactly(new Destination("꽝"), new Destination("5000"));
    }

    @DisplayName("Step이 있는 위치를 받으면 해당 위치와 다음에 위치한 결과를 서로 바꾼다")
    @Test
    void swapDestinations() {
        Destinations destinations = Destinations.of(List.of("꽝", "5000", "꽝", "3000"), 4);
        List<Destination> expected = List.of(
                new Destination("5000"),
                new Destination("꽝"),
                new Destination("3000"),
                new Destination("꽝")
        );

        assertThat(destinations.swapDestinations(List.of(0, 2))).isEqualTo(expected);
    }

    @DisplayName("인덱스 넘버로 해당 위치에 존재하는 Destination을 반환한다.")
    @Test
    void findDestinationByOrder() {
        Destinations destinations = Destinations.of(List.of("꽝", "5000"), 2);

        assertThat(destinations.findByOrder(1)).isEqualTo(new Destination("5000"));
    }

    @DisplayName("인덱스 값으로 이름을 찾을 때 0 미만의 값이나 총 이름의 개수를 초과하는 값을 입력하면 예외를 던진다.")
    @ValueSource(ints = {-1, 2})
    @ParameterizedTest
    void findDestinationByOutOfBoundsOrder(int order) {
        Destinations destinations = Destinations.of(List.of("꽝", "5000"), 2);

        assertThatIndexOutOfBoundsException()
                .isThrownBy(() -> destinations.findByOrder(order))
                .withMessage("유효하지 않은 값입니다.");
    }
}

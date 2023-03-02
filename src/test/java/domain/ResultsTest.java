package domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultsTest {

    @DisplayName("플레이어의 수와 같은 갯수의 결과가 입력되면 정상적으로 생성된다.")
    @Test
    void create_success() {
        List<Name> names = List.of(new Name("이름1"), new Name("이름2"));
        AtomicInteger index = new AtomicInteger();
        Players players = names.stream()
                .map(name -> new Player(name, new Position(index.getAndIncrement())))
                .collect(collectingAndThen(toList(), Players::new));
        assertDoesNotThrow(() -> new Results(List.of(new Result("당첨"), new Result("꽝")), players));
    }

    @DisplayName("플레이어의 수와 다른 갯수의 결과가 입력되면 예외를 반환한다..")
    @Test
    void create_fail_with_wrong_number_of_results() {
        List<Name> names = List.of(new Name("이름1"), new Name("이름2"));
        AtomicInteger index = new AtomicInteger();
        Players players = names.stream()
                .map(name -> new Player(name, new Position(index.getAndIncrement())))
                .collect(collectingAndThen(toList(), Players::new));
        assertThatThrownBy(() -> new Results(List.of(new Result("당첨")), players))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참가자의 수와 결과의 수는 같아야 합니다.");
    }
}

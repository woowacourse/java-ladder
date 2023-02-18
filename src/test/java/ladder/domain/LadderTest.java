package ladder.domain;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.IntStream;

class LadderTest {

    private List<Line> makeLines() {
        return IntStream.range(0, 5)
                .mapToObj(value -> new Line(List.of(Step.EMPTY)))
                .collect(toList());
    }

    @Test
    @DisplayName("사다리가 정상적으로 생성되어야 한다.")
    void create_success() {
        // expect
        assertThatNoException().isThrownBy(() -> {
            new Ladder(makeLines(), 3);
        });
    }
}

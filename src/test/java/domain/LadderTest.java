package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @DisplayName("각 인덱스에 따른 결과를 반환한다")
    @ParameterizedTest
    @CsvSource({"0, 1", "1, 0", "2, 2"})
    void getResultIndex(int index, int expect) {
        List<Line> lines = IntStream.range(0, 3)
                                    .mapToObj((count) -> new Line(2, () -> true))
                                    .collect(Collectors.toList());
        Ladder ladder = new Ladder(lines);

        Assertions.assertThat(ladder.getResultIndex(index)).isEqualTo(expect);
    }
}

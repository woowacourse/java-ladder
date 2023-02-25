package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class LineTest {

    private Line line;

    @BeforeEach
    void init() {
        this.line = new Line(3);
    }

    @DisplayName("이전 가로가 True면 다음 가로는 무조건 False이다.")
    @Test
    void 사다리_순서를_계산한다() {
        IntStream.range(0, line.getPoints().size() - 1)
                .filter(i -> line.getPoints().get(i) == true)
                .forEach(i -> Assertions.assertThat(line.getPoints().get(i + 1))
                        .isFalse());
    }

}

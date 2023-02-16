package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    @DisplayName("1을 받으면 true가 된다.")
    void makeTrue() {
        Line line = new Line();
        line.make(LineSource.of(1));

        Assertions.assertThat(line)
                .extracting("isExist")
                .isEqualTo(true);
    }
}

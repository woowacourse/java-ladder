package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @Test
    @DisplayName("1을 받으면 true가 된다.")
    void makeTrue() {
        Line line = new Line();
        line.make(true);

        assertThat(line.isExist())
                .isEqualTo(true);
    }

    @Test
    @DisplayName("0을 받으면 false가 된다.")
    void makeFalse() {
        var line = new Line();
        line.make(false);

        assertThat(line.isExist())
                .isEqualTo(false);
    }
}

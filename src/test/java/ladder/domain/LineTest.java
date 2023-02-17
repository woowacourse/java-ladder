package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @Test
    @DisplayName("라인 생성 true 케이스")
    void makeTrue() {

        Line line = new Line();
        line.make(true);

        assertThat(line.isExist())
                .isEqualTo(true);
    }

    @Test
    @DisplayName("라인 생성 false 케이스")
    void makeFalse() {

        Line line = new Line();
        line.make(false);

        assertThat(line.isExist())
                .isEqualTo(false);
    }
}

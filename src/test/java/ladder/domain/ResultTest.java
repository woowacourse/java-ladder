package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {
    @DisplayName("같은 위치를 가지면 true를 반환한다.")
    @Test
    void hasSameLocationTest() {
        Result result0 = new Result("100", 0);
        Result result1 = new Result("200", 1);

        assertAll(
                () -> assertThat(result0.hasSameLocation(0)).isTrue(),
                () -> assertThat(result1.hasSameLocation(0)).isFalse()
        );
    }
}

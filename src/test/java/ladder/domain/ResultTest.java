package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {
    @DisplayName("입력된 첫번째 인자를 보상으로, 두번째 인자를 위치로 가진다.")
    @Test
    void resultConstructTest() {
        Result result = new Result("100", 0);

        assertAll(
                () -> assertThat(result.reward()).isEqualTo("100"),
                () -> assertThat(result.location()).isEqualTo(0)
        );
    }

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

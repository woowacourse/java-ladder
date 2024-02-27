package ladder.domain;

import ladder.constant.PathStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.constant.PathStatus.EXIST;
import static org.assertj.core.api.Assertions.assertThat;

public class PathStatusTest {

    @DisplayName("true가 입력되면 EXIST를 반환한다.")
    @Test
    void returnNoneWhenStepExist() {
        assertThat(PathStatus.getStepStatus(true))
                .isEqualTo(EXIST);
    }

    @DisplayName("EXIST면 true를 반환한다.")
    @Test
    void cheRckIsExist() {
        assertThat(EXIST.isExist())
                .isTrue();
    }
}

package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StickTest {
    @Test
    @DisplayName("막대가 해당자리에 있는지 테스트")
    void isExistTest() {
        Assertions.assertThat(Stick.EXISTENCE.isExist()).isTrue();
    }

    @Test
    @DisplayName("막대가 해당자리에 없는지 테스트")
    void isNonExistTest() {
        Assertions.assertThat(Stick.NON_EXISTENCE.isExist()).isFalse();
    }
}

package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StickTest {

    @DisplayName("막대가 해당자리에 있는지 테스트")
    @Test
    void isExistTest() {

        Assertions.assertThat(Stick.EXISTENCE.isExist()).isTrue();
    }

    @DisplayName("막대가 해당자리에 없는지 테스트")
    @Test
    void isNonExistTest() {

        Assertions.assertThat(Stick.NON_EXISTENCE.isExist()).isFalse();
    }
}

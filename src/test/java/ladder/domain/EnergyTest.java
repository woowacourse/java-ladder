package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EnergyTest {

    @DisplayName("number이 6 이상일 경우 Health의 상태가 true이다.")
    @Test
    void isHealthyPersonTest() {
        Energy health = new Energy(() -> 6);

        Assertions.assertThat(health.isEnergetic()).isTrue();
    }

    @DisplayName("number이 5 이하일 경우 Health의 상태가 false이다.")
    @Test
    void isNotHealthyPersonTest() {
        Energy health = new Energy(() -> 4);

        Assertions.assertThat(health.isEnergetic()).isFalse();
    }

}

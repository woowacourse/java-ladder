package domain;

import exception.InvalidLineWeightException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeightTest {

    @DisplayName("입력 값이 조건에 맞는 경우 너비를 생선한다.")
    @Test
    void createSuccess() {
        Weight weight = new Weight(5);
        Assertions.assertThat(weight.getWeight()).isEqualTo(4);
    }

    @DisplayName("참가자 수가 10명보다 많은 경우 오류를 던진다.")
    @Test
    void lineCountOver10() {
        Assertions.assertThatThrownBy(() -> new Weight(11))
                  .isExactlyInstanceOf(InvalidLineWeightException.class);
    }

    @DisplayName("참가자 수가 2명보다 적은 경우 오류를 던진다.")
    @Test
    void lineCountUnder1() {
        Assertions.assertThatThrownBy(() -> new Weight(1))
                  .isExactlyInstanceOf(InvalidLineWeightException.class);
    }
}

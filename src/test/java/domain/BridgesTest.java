package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgesTest {
    //TODO 더 적합한 클래스 이름 고민하기

    @DisplayName("객체가 정상적으로 생성된다.")
    @Test
    void constructSuccessTest() {
        assertThatNoException()
                .isThrownBy(() -> new Bridges(5));
    }

    @DisplayName("높이가 자연수가 아니라면 예외가 발생한다.")
    @ParameterizedTest(name = "높이가 {0}인 경우 예외가 발생한다.")
    @ValueSource(ints = {-10, 0})
    void constructFailWithNotPositive(int height){
        //TODO 더 적합한 메서드 이름 고민
        assertThatThrownBy(() -> new Bridges(height))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void bridgesLengthTest() {
        //given
        int length = 5;

        //when
        Bridges bridges = new Bridges(length);

        //then
        assertThat(bridges.getBridges()).isSize(length);
    }
}

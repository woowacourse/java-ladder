package domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderTest {

    @DisplayName("객체가 정상적으로 생성된다.")
    @Test
    void constructSuccessTest() {
        assertThatNoException()
                .isThrownBy(() -> new Ladder(4, 5));
    }

    @DisplayName("높이가 자연수가 아니라면 예외가 발생한다.")
    @ParameterizedTest(name = "높이가 {0}인 경우 예외가 발생한다.")
    @ValueSource(ints = {-11, 0})
    void constructFailWithNotPositiveHeight(int height){
        //TODO 더 적합한 메서드 이름 고민
        assertThatThrownBy(() -> new Ladder(4, height))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-3, 0})
    void constructFailWithNotPositiveWidth(int personCount) {
        assertThatThrownBy(() -> new Ladder(personCount, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

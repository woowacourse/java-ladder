package domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderTest {

    @Test
    void constructSuccessTest() {
        assertThatNoException()
                .isThrownBy(() -> new Ladder(5));
    }

    @ParameterizedTest
    @ValueSource(ints = {-11, 0})
    void constructFailWithNotPositive(int height){
        //TODO 더 적합한 메서드 이름 고민
        assertThatThrownBy(() -> new Ladder(height))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

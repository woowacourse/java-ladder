package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
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
        assertThatThrownBy(() -> new Ladder(4, height))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사람 수가 자연수가 아니라면 예외가 발생한다.")
    @ParameterizedTest(name = "사람 수가 {0}인 경우 예외가 발생한다.")
    @ValueSource(ints = {-3, 0})
    void constructFailWithNotPositiveWidth(int personCount) {
        assertThatThrownBy(() -> new Ladder(personCount, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Ladder 가 사람 수 - 1 개 만큼의 Bridges 를 가진다.")
    @Test
    void ladderContainsRightLength() {
        //given
        int personCount = 5;

        //when
        Ladder ladder = new Ladder(personCount, 4);

        //then
        assertThat(ladder.getBridge()).hasSize(personCount - 1);
    }
}

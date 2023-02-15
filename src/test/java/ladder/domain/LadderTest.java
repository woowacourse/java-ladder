package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {

    @Test
    @DisplayName("0이하의 값으로 Ladder생성시 예외가 발생한다.")
    void inValidLadderSizeTest(){
        assertThatThrownBy(()-> new Ladder(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1이상의 값으로 Ladder생성 시 사이즈 테스트")
    void checkValidLadderSizeTest(){
        assertThat(new Ladder(3).getFloors().size())
                .isEqualTo(3);
    }
}

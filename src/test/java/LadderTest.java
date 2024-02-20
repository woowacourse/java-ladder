import domain.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {
    @Test
    @DisplayName("Ladder를 생성한다")
    void createLadder() {
        //given

        //when

        //then
        assertThatCode(() -> new Ladder()).doesNotThrowAnyException();
    }

}

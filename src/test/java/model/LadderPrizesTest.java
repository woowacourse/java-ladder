package model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderPrizesTest {

    @Test
    @DisplayName("존재하지 않는 참여자의 결과를 요청하면 예외가 발생한다.")
    void createInvalidNameRequest() {
        //given
        LadderGameResult ladderGameResult = LadderGameResult.of(List.of("reddy", "anna"), List.of("당첨", "꽝"));

        //when & then
        Assertions.assertThatThrownBy(() -> ladderGameResult.getPrize("brown"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

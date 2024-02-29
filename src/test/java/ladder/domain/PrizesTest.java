package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizesTest {

    @DisplayName("상품 생성 테스트")
    @Test
    void createPrizeTest() {
        Prizes prizes = new Prizes(new ArrayList<>(List.of("꽝", "3000", "꽝", "5000")), 4);
    }

    @DisplayName("상품의 개수가 참여자 인원수와 일치하지 않을 경우 예외를 발생한다.")
    @Test
    void validatePrizesCountTest() {
        int personCount = 5;

        List<String> prizesList = List.of("꽝", "3000", "꽝", "5000");
        int prizesCount = prizesList.size();

        assertThatThrownBy(() -> new Prizes(new ArrayList<>(prizesList), personCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품의 개수(" + prizesCount + "개)와 참여자 인원수(" + personCount + "명)는 일치해야 합니다.");
    }
}

package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizesTest {

    @DisplayName("상품 생성 테스트")
    @Test
    void createPrizeTest() {
        Prizes prizes = new Prizes(new ArrayList<>(List.of("꽝", "3000", "꽝", "5000")));
    }
}

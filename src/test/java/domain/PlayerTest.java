package domain;

import helper.StubPossiblePointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    @Test
    @DisplayName("플레이어에 따른 원하는 결과값이 나오는지 확인")
    void calculateResult() {
        int startIndex = 0;
        String result = "2";
        Player player = new Player("pobi", startIndex);
        Ladder ladder = new Ladder(5, 4, new StubPossiblePointGenerator());

        assertThat(player.calculateResult(ladder, new Results(4, List.of("1", "2", "3", "4"))))
                .isEqualTo(result);
    }
}

package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderResultItemTest {
    @DisplayName("생성된다.")
    @Test
    void createTest() {
        assertDoesNotThrow(() -> new LadderResultItem("꽝"));
    }


    @DisplayName("이름을 볼 수 있다.")
    @Test
    void getName() {
        String name = "나는 결과";
        LadderResultItem ladderResultItem = new LadderResultItem(name);
        assertThat(ladderResultItem.getName()).isEqualTo(name);
    }
}

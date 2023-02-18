package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PlayerNamesTest {
    @Test
    @DisplayName("입력받은 이름들을 ,를 기준으로 나눈다.")
    void test_() {
        // when
        PlayerNames playerNames = new PlayerNames("chech,abel");
        
        // then
        assertThat(playerNames.getNames())
                .contains("chech", "abel");
    }
}

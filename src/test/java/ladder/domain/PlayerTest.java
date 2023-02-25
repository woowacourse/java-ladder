package ladder.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    @DisplayName("이름을 입력받아 Player를 생성한다")
    public void shouldCreatePlayerWhenInputName() {
        // given
        // when
        // then
        assertDoesNotThrow(() -> new Player("name"));
    }

    @Test
    @DisplayName("결과를 입력받아 Player의 결과로 저장한다.")
    void shouldSaveResultWhenRequest() {
        Player player = new Player("name");
        assertDoesNotThrow(() -> player.saveResult(new Result("content")));
    }
}

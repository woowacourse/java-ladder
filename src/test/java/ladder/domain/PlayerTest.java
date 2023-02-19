package ladder.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    @DisplayName("이름과 위치를 입력받아 Player를 생성한다")
    public void shouldCreatePlayerWhenInputNameAndPosition() {
        // given
        // when
        // then
        assertDoesNotThrow(() -> new Player("name",0));
    }

}

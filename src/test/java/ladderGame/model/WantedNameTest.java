package ladderGame.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WantedNameTest {

    @Test
    @DisplayName("참여자 목록에 있지 않은 사람을 입력할 경우 예외처리 된다")
    void inputWantedName() {
        Players players = new Players(List.of("pobi", "crong", "honux", "jk"));

        assertAll(
                () -> assertThatThrownBy(() -> new WantedName("popo", players))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("참여자 목록 중에서 골라야 합니다."),
                () -> assertThatCode(() -> new WantedName("pobi", players))
                        .doesNotThrowAnyException(),
                () -> assertThatCode(() -> new WantedName("all", players))
                        .doesNotThrowAnyException()
        );
    }
}

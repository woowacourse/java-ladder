package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {
    @DisplayName("라인이 존재할 때 두 유저의 위치가 바뀌어야 한다.")
    @Test
    void shouldFailUserMaintain() {
        List<Boolean> points = List.of(false, true, false, false);
        ArrayList<String> userNames = new ArrayList<>(List.of("dino", "mango", "study"));
        assertThat(Game.compareLineAndUsers(userNames, points)).isNotEqualTo(List.of("dino", "mango", "study"));
    }
}

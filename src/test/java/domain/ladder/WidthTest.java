package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import domain.player.PlayerNames;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WidthTest {

    @DisplayName("사다리 너비는 (참가자수 - 1) 만큼의 값을 가진다.")
    @Test
    void calculateLadderWidth() {
        //given
        final PlayerNames playerNames = PlayerNames.from(List.of("a", "b", "c", "d"));
        final int expectedWidth = 3;

        //when
        final Width width = Width.from(playerNames);

        //then
        assertThat(width).isEqualTo(new Width(expectedWidth));
    }
}

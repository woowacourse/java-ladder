package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import domain.player.PlayerNames;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WidthTest {

    @DisplayName("참가자들로부터 사다리의 너비를 구한다.")
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

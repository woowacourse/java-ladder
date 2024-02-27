package domain.ladder;

import domain.Players;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WidthTest {

    @DisplayName("참가자들로부터 사다리의 너비를 구한다.")
    @Test
    void calculateLadderWidth() {
        //given
        final Players players = new Players(List.of("a", "b", "c", "d"));
        final int expectedWidth = 4;

        //when
        final Width width = Width.from(players);

        //then
        Assertions.assertThat(width).isEqualTo(new Width(expectedWidth));
    }
}

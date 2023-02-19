package domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import domain.vo.Height;
import domain.vo.Width;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    @DisplayName("사다리를 생성한다.")
    public void makeLadder() {
        //given
        Height height = new Height(5);
        Width width = new Width(5);

        //when
        Ladder ladder = Ladder.makeLadder(height, width);

        //then
        assertThat(ladder.getHeight()).isEqualTo(height);
        assertThat(ladder.getWidth()).isEqualTo(width);
    }
}

package laddergame.domain;

import laddergame.domain.Ladder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        ladder = new Ladder(4, 5);
    }

    @Test
    public void 객체_생성_검사() {
        assertThat(ladder).isEqualTo(new Ladder(4, 5));
    }

    @Test
    public void 생성된_사다리의_높이_검사() {
        assertThat(ladder.getHeight()).isEqualTo(5);
    }

    @Test
    public void 생성된_사다리의_가로_길이_검사() {
        assertThat(ladder.getWidth()).isEqualTo(4);
    }
}

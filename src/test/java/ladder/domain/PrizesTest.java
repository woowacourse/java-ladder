package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizesTest {

    private Prizes prizes;

    @BeforeEach
    void setUp() {
        prizes = new Prizes("1000,2000,3000");
    }

    @Test
    void 생성() {
        assertThat(prizes.getPrizes()).contains(new Prize("1000"), new Prize("2000"), new Prize("3000"));
    }

    @Test
    void 인덱스() {
        assertThat(prizes.getPrize(1)).isEqualTo(new Prize("2000"));
    }
}

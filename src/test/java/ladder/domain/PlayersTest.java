package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {
    @Test
    void from_중복된이름() throws DuplicatedNameException {
        String hi = "hi";
        assertThrows(DuplicatedNameException.class, () -> Players.from(Arrays.asList(hi, hi)));
    }

    @Test
    void size() {
        assertThat(new Players(Arrays.asList(Player.from("hi"))).size()).isEqualTo(1);
    }
}
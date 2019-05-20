package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayersTest {
    @Test
    public void 올바른_이름이_입력됐을_때() {
        String[] playerNames = {"pobi", "cony", "done"};

        assertThatCode(() -> {
            new Players(playerNames);
        }).doesNotThrowAnyException();
    }

    @Test
    public void 중복된_이름이_입력됐을_때() {
        String[] playerNames = {"pobi", "cony", "pobi"};

        assertThatThrownBy(() -> {
            new Players(playerNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

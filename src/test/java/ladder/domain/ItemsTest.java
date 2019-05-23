package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ItemsTest {
    @Test
    void 올바른_실행_결과들이_입력됐을_때() {
        String[] itemNames = {"꽝", "당첨", "꽝"};
        String[] playerNames = {"pobi", "cony", "done"};
        Players players = new Players(playerNames);

        assertThatCode(() -> {
            new Items(itemNames, players);
        }).doesNotThrowAnyException();
    }

    @Test
    public void 사람_수와_실행_결과의_수가_다를_때() {
        String[] itemNames = {"꽝", "당첨"};
        String[] playerNames = {"pobi", "cony", "done"};
        Players players = new Players(playerNames);

        assertThatThrownBy(() -> {
            new Items(itemNames, players);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

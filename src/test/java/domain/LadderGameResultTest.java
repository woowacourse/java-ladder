package domain;

import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameResultTest {

    @Test
    @DisplayName("User를 통해 Result를 찾을 수 있다.")
    void findByNameTest() {
        Map<User, Result> map = new HashMap<>();
        User kodak = new User("kodak");
        Result win = new Result("당첨");
        map.put(kodak, win);
        LadderGameResult ladderGameResult = new LadderGameResult(map);

        Assertions.assertThat(ladderGameResult.findByUser(kodak)).isEqualTo(win);
    }
}

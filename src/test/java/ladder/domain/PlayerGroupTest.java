package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerGroupTest {
    @Test
    void 플레이어_그룹이_잘_생성되는지_테스트() {
        List<String> playerNames = Arrays.asList("a,b".split(","));
        assertThat(new PlayerGroup(playerNames)).isEqualTo(new PlayerGroup(playerNames));
    }
}

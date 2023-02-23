package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class RewardsTest {

    @Test
    void 실행_결과는_플레이어의_수와_같아야한다() {
        int playerCount = 4;
        String input = "a,b";
        Assertions.assertThatThrownBy(() -> new Rewards(input, playerCount)).isInstanceOf(IllegalArgumentException.class);
    }
}

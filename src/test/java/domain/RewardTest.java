package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class RewardTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 공백이_포함되어_있으면_예외처리(String input) {
        Assertions.assertThatThrownBy(() -> new Reward(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다섯글자_이상이면_예외처리() {
        String input = "100000";
        Assertions.assertThatThrownBy(() -> new Reward(input)).isInstanceOf(IllegalArgumentException.class);
    }
}

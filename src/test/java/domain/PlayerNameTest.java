package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PlayerNameTest {

    @Test
    void 여섯글자_이상의_이름은_예외처리() {
        String input = "judith";
        Assertions.assertThatThrownBy(() -> new PlayerName(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 빈_칸이_포함된_이름은_예외처리(String input) {
        Assertions.assertThatThrownBy(() -> new PlayerName(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_all_이면_예외처리() {
        String input = "all";
        Assertions.assertThatThrownBy(() -> new PlayerName(input)).isInstanceOf(IllegalArgumentException.class);
    }
}

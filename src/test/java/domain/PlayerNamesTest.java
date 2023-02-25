package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PlayerNamesTest {
    @Test
    void 플레이어가_한_명만_입력되면_예외처리() {
        List<String> input = List.of("a");
        Assertions.assertThatThrownBy(() -> new PlayerNames(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b,,", "a,,b"})
    void 공백이_포함된_이름은_예외처리(String input) {
        Assertions.assertThatThrownBy(() -> new PlayerNames(List.of(input.split(",", -1)))).isInstanceOf(IllegalArgumentException.class);
    }
}

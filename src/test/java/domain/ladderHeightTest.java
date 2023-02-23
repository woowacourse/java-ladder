package domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ladderHeightTest {

    @Test
    void 정수값이_아니면_예외처리() {
        String input = "r";
        Assertions.assertThatThrownBy(() -> new LadderHeight(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

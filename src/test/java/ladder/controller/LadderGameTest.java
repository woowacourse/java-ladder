package ladder.controller;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    @Test
    void 보상_글자수_초과_테스트() {
        assertThat(LadderGame.isOverLengthLimit(false, "123456")).isTrue();
    }

    @Test
    void 보상_글자수_미만_테스트() {
        assertThat(LadderGame.isOverLengthLimit(false, "")).isTrue();
    }
}

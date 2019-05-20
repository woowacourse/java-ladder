package ladder.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderHeightTest {
    @Test
    void 이름이_없거나_빈칸인_경우_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderHeight(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderHeight("");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderHeight(" ");
        });
    }

    @Test
    void 기준치_미만의_값을_입력한_경우_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderHeight(0);
        });
    }
}
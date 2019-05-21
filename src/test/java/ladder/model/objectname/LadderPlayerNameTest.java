package ladder.model.objectname;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderPlayerNameTest {
    @Test
    void 기준치를_넘는_이름_길이를_입력한_경우_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderPlayerName("banana");
        });
    }
}
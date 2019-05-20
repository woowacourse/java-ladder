package ladder.model.objectname;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderObjectNameTest {
    @Test
    void 이름이_없거나_빈칸인_경우_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderObjectName(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderObjectName("");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderObjectName(" ");
        });
    }
}
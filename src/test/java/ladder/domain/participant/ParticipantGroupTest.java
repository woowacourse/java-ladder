package ladder.domain.participant;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

class ParticipantGroupTest {
    @Test
    public void 최소_참가자_체크() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ParticipantGroup(Arrays.asList("a"));
        });
    }

    @Test
    public void 중복_참가자() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ParticipantGroup(Arrays.asList("a", "a"));
        });
    }
}
package ladder.domain.ladder;

import ladder.domain.participant.ParticipantGroup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {
    ParticipantGroup participantGroup;

    @BeforeEach
    void setUp() {
        participantGroup = new ParticipantGroup(Arrays.asList("pobi", "crong"));
    }

    @Test
    void 높이가_1_이하인_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            LadderGenerator.generate(participantGroup, 0);
        });
    }
}

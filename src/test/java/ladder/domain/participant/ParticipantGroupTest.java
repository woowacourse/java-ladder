package ladder.domain.participant;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParticipantGroupTest {
    @Test
    void 생성() {
        ParticipantGroup participantGroup = new ParticipantGroup(Arrays.asList("1", "2"));
        assertThat(participantGroup).isEqualTo(new ParticipantGroup(Arrays.asList("1", "2")));
    }

    @Test
    void 참가자_최소_숫자를_만족하지_않을_경우() {
        assertThrows(InvalidParticipantGroup.class, () -> {
            new ParticipantGroup(Arrays.asList("1"));
        });
    }

    @Test
    void 중복된_이름을_가지는_경우() {
        assertThrows(InvalidParticipantGroup.class, () -> {
            new ParticipantGroup(Arrays.asList("1", "2", "1"));
        });
    }
}

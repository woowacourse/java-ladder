package ladder.domain.participant;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParticipantTest {
    @Test
    void 참가자_생성() {
        assertThat(new Participant("pobi", new Position(0))).isEqualTo(new Participant("pobi", new Position(0)));
    }

    @Test
    void 참가자_이름_5자_초과_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Participant("pobico", new Position(0));
        });
    }

    @Test
    void 참가자_이름이_All_인_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Participant("all", new Position(0));
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Participant("All", new Position(0));
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Participant("ALL", new Position(0));
        });
    }
}
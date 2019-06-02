package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParticipantTest {
    @Test
    void 참가자_생성() {
        assertThat(new Participant("pobi")).isEqualTo(new Participant("pobi"));
    }

    @Test
    void 참가자_이름_5자_초과_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Participant("pobico");
        });
    }

    @Test
    void 참가자_이름이_All_인_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Participant("all");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Participant("All");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Participant("ALL");
        });
    }
}
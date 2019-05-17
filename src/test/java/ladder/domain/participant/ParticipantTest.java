package ladder.domain.participant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ParticipantTest {
    @Test
    public void 이름5글자제한() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Participant("abcdef");
        });
    }

    @Test
    public void 이름명령어제한() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Participant("all");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Participant("All");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Participant("aLl");
        });
    }
}
package laddergame.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static laddergame.TestDummy.PERSON_HYENA;
import static laddergame.TestDummy.PERSON_ROSIE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @Test
    void throwExceptionWhenParticipantIsNull() {
        final Participants participants = null;
        final Height height = new Height(1);
        assertThatThrownBy(() -> new Ladder(participants, height))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void throwExceptionWhenHeightIsNull() {
        final Participants participants = new Participants(List.of(PERSON_HYENA));
        final Height height = null;
        assertThatThrownBy(() -> new Ladder(participants, height))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void create() {
        final Participants participants = new Participants(List.of(PERSON_HYENA, PERSON_ROSIE));
        final Height height = new Height(2);
        Assertions.assertDoesNotThrow(() -> new Ladder(participants, height));
    }
}
package laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static laddergame.TestDummy.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


class ParticipantsTest {
    @Test
    void create() {
        final List<Name> names = List.of(new Name("hyena"), new Name("rosie"));

        assertDoesNotThrow(() -> new Participants(names));
    }

    @Test
    void throwExceptionWhenPeopleIsEmpty() {
        final List<Name> names = List.of();

        assertThatThrownBy(() -> new Participants(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void throwExceptionWhenPeopleIsNull() {
        final List<Name> names = null;

        assertThatThrownBy(() -> new Participants(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getSize() {
        final List<Name> names = List.of(NAME_ROSIE, NAME_HYENA);
        final Participants participants = new Participants(names);
        final int totalSize = participants.getSize();

        assertThat(totalSize).isEqualTo(names.size());
    }

    @Test
    void getNames() {
        assertThat(PARTICIPANTS_SIZE_2.getNames()).contains("hyena", "rosie");
    }
}
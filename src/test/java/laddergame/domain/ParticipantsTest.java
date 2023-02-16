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
        final List<Person> people = List.of(new Person("hyena"), new Person("rosie"));

        assertDoesNotThrow(() -> new Participants(people));
    }

    @Test
    void throwExceptionWhenPeopleIsEmpty() {
        final List<Person> people = List.of();

        assertThatThrownBy(() -> new Participants(people))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void throwExceptionWhenPeopleIsNull() {
        final List<Person> people = null;

        assertThatThrownBy(() -> new Participants(people))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getSize() {
        final List<Person> people = List.of(PERSON_ROSIE, PERSON_HYENA);
        final Participants participants = new Participants(people);
        final int totalSize = participants.getSize();
        assertThat(totalSize).isEqualTo(people.size());
    }

    @Test
    void getNames() {
        assertThat(PARTICIPANTS_SIZE_2.getNames()).contains("hyena", "rosie");
    }
}
package laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


class ParticipantsTest {
    @Test
    void create() {
        final List<Person> people = List.of(new Person("헤나"), new Person("로지"));

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

}
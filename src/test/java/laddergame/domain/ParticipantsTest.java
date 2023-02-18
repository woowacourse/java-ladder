package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static laddergame.TestDummy.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("참여자")
class ParticipantsTest {

    @DisplayName("생성된다.")
    @Test
    void create() {
        final List<Name> names = List.of(new Name("hyena"), new Name("rosie"));

        assertDoesNotThrow(() -> new Participants(names));
    }

    @DisplayName("이름 목록이 비어있을 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenNamesIsEmpty() {
        final List<Name> names = List.of();

        assertThatThrownBy(() -> new Participants(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름 목록이 null일 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenNamesIsNull() {
        final List<Name> names = null;

        assertThatThrownBy(() -> new Participants(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름 목록의 크기를 가져온다.")
    @Test
    void getSize() {
        final List<Name> names = List.of(NAME_ROSIE, NAME_HYENA);
        final Participants participants = new Participants(names);
        final int totalSize = participants.getSize();

        assertThat(totalSize).isEqualTo(names.size());
    }

    @DisplayName("이름 목록을 가져온다.")
    @Test
    void getNames() {
        assertThat(PARTICIPANTS_SIZE_2.getNames()).contains("hyena", "rosie");
    }
}

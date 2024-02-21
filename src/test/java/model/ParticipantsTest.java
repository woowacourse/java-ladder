package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantsTest {

    @DisplayName("List<model.Participant>을 받아 model.Participants 객체를 생성한다.")
    @Test
    void createParticipants() {
        List<Participant> given = List.of(
                new Participant("ash"),
                new Participant("daon")
        );
        assertThatCode(() -> new Participants(given))
                .doesNotThrowAnyException();
    }

    @DisplayName("model.Participants 객체에 null 값이 입력되면 예외가 발생한다")
    @Test
    void validateParticipantsSizeWhenNull() {
        List<Participant> given = null;
        assertThatThrownBy(() -> new Participants(given))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("model.Participants 객체에 참여자 수가 없으면 예외가 발생한다")
    @Test
    void validateParticipantsSizeWhenZero() {

        List<Participant> given = List.of();
        assertThatThrownBy(() -> new Participants(given))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("model.Participants 객체에 참여자 수가 1명이면 예외가 발생한다.")
    @Test
    void validateParticipantsSizeWhenOne() {
        List<Participant> given = List.of(
                new Participant("daon")
        );
        assertThatThrownBy(() -> new Participants(given))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참여자 수를 반환한다.")
    @Test
    void getParticipantsSize() {
        List<Participant> given = List.of(
                new Participant("daon"),
                new Participant("ash")
        );
        Participants participants = new Participants(given);
        int result = participants.getSize();

        assertThat(result).isEqualTo(given.size());
    }
}

package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantsTest {

    @DisplayName("Participants 객체에 null 값이 입력되면 예외가 발생한다")
    @Test
    void validateParticipantsSizeWhenNull() {
        List<Participant> given = null;
        assertThatThrownBy(() -> new Participants(given))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Participants 객체에 참여자 수가 0명이면 예외가 발생한다")
    @Test
    void validateParticipantsSizeWhenZero() {
        List<Participant> given = List.of();
        assertThatThrownBy(() -> new Participants(given))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Participants 객체에 참여자 수가 1명이면 예외가 발생한다.")
    @Test
    void validateParticipantsSizeWhenOne() {
        List<Participant> given = List.of(
                new Participant("daon")
        );
        assertThatThrownBy(() -> new Participants(given))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("전체 참여자 수를 반환한다.")
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

    @DisplayName("참여자 중 중복되는 이름이 있다면 예외를 반환한다.")
    @Test
    void validateDuplicatedParticipant() {
        List<Participant> given = List.of(
                new Participant("daon"),
                new Participant("daon")
        );

        assertThatThrownBy(() -> new Participants(given))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 참여자 이름이 중복되었습니다.");
    }
}

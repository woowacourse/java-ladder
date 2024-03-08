package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantsTest {

    @DisplayName("Participants 객체에 null 값이 입력되면 예외가 발생한다")
    @Test
    void validateParticipantsSizeWhenNull() {
        List<Participant> emptyInput = null;
        assertThatThrownBy(() -> new Participants(emptyInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Participants 객체에 참여자 수가 0명이면 예외가 발생한다")
    @Test
    void validateParticipantsSizeWhenZero() {
        List<Participant> blankInput = List.of();
        assertThatThrownBy(() -> new Participants(blankInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Participants 객체에 참여자 수가 1명이면 예외가 발생한다.")
    @Test
    void validateParticipantsSizeWhenOne() {
        List<Participant> inputOutOfRange = List.of(
                new Participant("daon")
        );
        assertThatThrownBy(() -> new Participants(inputOutOfRange))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("전체 참여자 수를 반환한다.")
    @Test
    void getParticipantsSize() {
        List<Participant> entireParticipants = List.of(
                new Participant("daon"),
                new Participant("ash")
        );
        Participants participants = new Participants(entireParticipants);
        int result = participants.getSize();

        assertThat(result).isEqualTo(entireParticipants.size());
    }

    @DisplayName("참여자 중 중복되는 이름이 있다면 예외를 반환한다.")
    @Test
    void validateDuplicatedParticipant() {
        List<Participant> entireParticipants = List.of(
                new Participant("daon"),
                new Participant("daon")
        );

        assertThatThrownBy(() -> new Participants(entireParticipants))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("조회한 사람의 이름이 참여자 명단에 존재하는지 확인한다.")
    @Test
    void searchSpecificParticipant() {
        Participant ash = new Participant("ash");
        Participant daon = new Participant("daon");
        Participants participants = new Participants(List.of(ash, daon));

        Participant result = participants.findTargetParticipant("ash");
        assertThat(result).isEqualTo(ash);
    }

    @DisplayName("조회한 사람의 이름이 참여자 명단에 존재하지 않는다면 예외를 반환한다.")
    @Test
    void searchSpecificParticipantFailure() {
        Participant ash = new Participant("ash");
        Participant daon = new Participant("daon");
        Participants participants = new Participants(List.of(ash, daon));


        assertThatThrownBy(() -> participants.findTargetParticipant("ted"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

package laddergame.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

class ParticipantsTest {
    @DisplayName("참여자수가 null이거나 비어있다면 예외가 발생한다")
    @NullSource
    @EmptySource
    @ParameterizedTest
    void validateParticipantsSizeWhenNull(List<Participant> given) {
        assertThatThrownBy(() -> new Participants(given))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참여자 수가 1명이면 예외가 발생한다.")
    @Test
    void validateParticipantsSizeWhenOne() {
        List<Participant> given = List.of(
                new Participant("daon")
        );
        assertThatThrownBy(() -> new Participants(given))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 참여자는 ")
                .hasMessageContaining("명 이상이어야 한다.");
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

    @DisplayName("참여자 중 이름이 중복되어 있으면 예외를 반환한다.")
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

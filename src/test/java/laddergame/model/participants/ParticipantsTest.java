package laddergame.model.participants;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

class ParticipantsTest {
    @DisplayName("참여자수가 null이거나 비어있다면 예외가 발생한다")
    @NullSource
    @EmptySource
    @ParameterizedTest
    void validateParticipantsSizeWhenNull(List<Participant> given) {
        //when //then
        assertThatThrownBy(() -> new Participants(given))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참여자 수가 1명이면 예외가 발생한다.")
    @Test
    void validateParticipantsSizeWhenOne() {
        //given
        List<Participant> given = List.of(new Participant("daon"));
        //when //then
        assertThatThrownBy(() -> new Participants(given))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참여자 수를 반환한다.")
    @Test
    void getParticipantsSize() {
        //given
        List<Participant> given = List.of(
                new Participant("daon"),
                new Participant("ash")
        );
        //when
        Participants participants = new Participants(given);
        int result = participants.getSize();
        //then
        assertThat(result).isEqualTo(given.size());
    }

    @DisplayName("참여자 중 이름이 중복되어 있으면 예외를 반환한다.")
    @Test
    void validateDuplicatedParticipant() {
        //given
        List<Participant> given = List.of(
                new Participant("daon"),
                new Participant("daon")
        );
        //when //then
        assertThatThrownBy(() -> new Participants(given))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참여자가 포함되어 있는지 판단한다.")
    @ParameterizedTest
    @CsvSource(value = {"daon,true", "mason,true", "jk,true", "lilly,false", "any,false"})
    void contains(String given, boolean expected) {
        //given
        Participant participant = new Participant(given);
        //when
        Participants participants = Stream.of("daon", "mason", "ted", "jk")
                .map(Participant::new)
                .collect(collectingAndThen(toList(), Participants::new));
        boolean result = participants.contains(participant);
        //then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("참여자의 인덱스를 리스트로 반환한다.")
    @Test
    void getIndexInfos() {
        //given
        Participants participants = Stream.of("daon", "mason", "ted", "jk")
                .map(Participant::new)
                .collect(collectingAndThen(toList(), Participants::new));
        //when
        List<IndexInfo> result = participants.getIndexInfos();
        //then
        assertThat(result).hasSize(participants.getSize());
    }

    @DisplayName("참여자가 속한 인덱스를 반환한다, 속하지 않을 경우 -1을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"daon,0", "mason,1", "jk,3", "lilly,-1", "any,-1"})
    void indexOf(String given, int expected) {
        Participant participant = new Participant(given);

        Participants participants = Stream.of("daon", "mason", "ted", "jk")
                .map(Participant::new)
                .collect(collectingAndThen(toList(), Participants::new));

        int result = participants.indexOf(participant);
        assertThat(result).isEqualTo(expected);
    }
}

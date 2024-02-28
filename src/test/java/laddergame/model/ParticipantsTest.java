package laddergame.model;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("참여자가 포함되어 있는지 판단한다.")
    @ParameterizedTest
    @CsvSource(value = {"daon,true", "mason,true", "jk,true", "lilly,false", "any,false"})
    void contains(String given, boolean expected) {
        Participant participant = new Participant(given);

        Participants participants = Stream.of("daon", "mason", "ted", "jk")
                .map(Participant::new)
                .collect(collectingAndThen(toList(), Participants::new));

        boolean result = participants.contains(participant);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("참여자의 인덱스를 리스트로 반환한다.")
    @Test
    void getIndexInfos() {
        Participants participants = Stream.of("daon", "mason", "ted", "jk")
                .map(Participant::new)
                .collect(collectingAndThen(toList(), Participants::new));

        List<Integer> result = participants.getIndexInfos();
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

    @DisplayName("인덱스에 해당하는 참가자를 찾는다.")
    @Nested
    class findByIndex {
        @DisplayName("각 인덱스에 해당하는 참가자를 반환한다.")
        @Test
        void find() {
            Participants participants = Stream.of("daon", "mason", "ted", "jk")
                    .map(Participant::new)
                    .collect(collectingAndThen(toList(), Participants::new));

            assertAll(
                    () -> assertThat(participants.findByIndex(0).getName()).isEqualTo("daon"),
                    () -> assertThat(participants.findByIndex(1).getName()).isEqualTo("mason"),
                    () -> assertThat(participants.findByIndex(2).getName()).isEqualTo("ted"),
                    () -> assertThat(participants.findByIndex(3).getName()).isEqualTo("jk")
            );
        }

        @DisplayName("유효하지 않는 인덱스로 조회하면 예외를 발생한다.")
        @ParameterizedTest
        @ValueSource(ints = {-10, -2, -1, 5, 6, 7, 8})
        void findInvalidIndex(int given) {
            Participants participants = Stream.of("daon", "mason", "ted", "jk")
                    .map(Participant::new)
                    .collect(collectingAndThen(toList(), Participants::new));

            assertThatThrownBy(() -> participants.findByIndex(given))
                    .isInstanceOf(IllegalStateException.class);
        }
    }
}

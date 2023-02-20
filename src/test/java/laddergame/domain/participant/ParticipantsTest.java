package laddergame.domain.participant;

import laddergame.domain.exception.DuplicateException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParticipantsTest {

    private String participantNames;

    @BeforeAll
    void init() {
        participantNames = "pobi,honux,crong,jk";
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi"})
    @DisplayName("입력받은 참여자의 수가 1명이면, 예외가 발생한다.")
    void create_givenSingleCountParticipant_thenFail(final String names) {
        assertThatThrownBy(() -> Participants.create(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 참가자는 최소 1명 이상 입력해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,pobi", "pobi, pobi, pobi "})
    @DisplayName("입력받은 이름에 중복값이 존재하면, 예외가 발생한다.")
    void create_givenDuplicatedNames_thenFail(final String names) {
        assertThatThrownBy(() -> Participants.create(names))
                .isInstanceOf(IllegalArgumentException.class)
                .isExactlyInstanceOf(DuplicateException.class)
                .hasMessage(DuplicateException.errorMessage);
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,jiwon,hoocu:3", "choco,jelly,pen,water:4"}, delimiter = ':')
    @DisplayName("참여자 이름의 수만큼 참여자가 생성된다.")
    void size_givenParticipantNames_thenReturnParticipantCount(final String names, final int expectedSize) {
        // given
        Participants participants = Participants.create(names);

        // when
        int actualSize = participants.size();

        // then
        assertThat(actualSize).isEqualTo(expectedSize);
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi:0", "honux:1", "crong:2", "jk:3", " pobi:0", "pobi :0", " pobi :0"}, delimiter = ':')
    @DisplayName("참여자 리스트에 존재하는 참여자 이름을 입력하면, 해당 참여자 리스트를 반환한다.")
    void getValidParticipantNames_givenValidParticipantName_thenReturnParticipantName(final String validParticipantName,
                                                                                      final int participantOrder) {
        // given
        Participants participants = Participants.create(participantNames);
        Participant participant = Participant.create(validParticipantName.trim(), participantOrder);

        // when
        List<Participant> targetParticipantNames = participants.getResultParticipants(validParticipantName);

        // then
        assertThat(targetParticipantNames.size())
                .isEqualTo(1);

        assertThat(targetParticipantNames)
                .isEqualTo(List.of(participant));
    }

    @ParameterizedTest
    @ValueSource(strings = {"all"})
    @DisplayName("all을 입력했다면, 전체 참여자 이름 리스트를 반환한다.")
    void getValidParticipantNames_givenAll_thenReturnAllParticipantNames(final String allParticipantName) {
        // given
        Participants participants = Participants.create(participantNames);
        Participant firstParticipant = Participant.create("pobi", 0);
        Participant secondParticipant = Participant.create("honux", 1);
        Participant thirdParticipant = Participant.create("crong", 2);
        Participant fourthParticipant = Participant.create("jk", 3);

        // when
        List<Participant> targetParticipantNames = participants.getResultParticipants(allParticipantName);

        // then
        assertThat(targetParticipantNames.size())
                .isEqualTo(4);

        assertThat(targetParticipantNames)
                .isEqualTo(List.of(firstParticipant, secondParticipant, thirdParticipant, fourthParticipant));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobib", "hoho", "", " "})
    @DisplayName("참여자 리스트에 존재하지 않는 참여자 이름을 입력하면, 예외가 발생한다.")
    void getValidParticipantNames_givenInvalidParticipantName_thenFail(final String invalidParticipantName) {
        // given
        Participants participants = Participants.create(participantNames);

        // when, then
        assertThatThrownBy(() -> participants.getResultParticipants(invalidParticipantName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 참여자 리스트에 존재하지 않습니다. 현재 참여자 리스트 = " + participantNames);
    }
}

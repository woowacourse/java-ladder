package laddergame.domain.participant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantsTest {

    private static final String ERROR_MESSAGE_HEAD = "[ERROR]";

    @ParameterizedTest
    @ValueSource(strings = {"pobi,pobi"})
    @DisplayName("입력받은 이름에 중복값이 존재하면, 예외가 발생한다.")
    void throws_exception_if_names_contain_duplicates(String names) {
        assertThatThrownBy(() -> Participants.create(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_HEAD);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi"})
    @DisplayName("입력받은 참여자의 수가 1명이면, 예외가 발생한다.")
    void throws_exception_if_names_consist_of_one_name(String names) {
        assertThatThrownBy(() -> Participants.create(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_HEAD);
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,jiwon,hoocu:3", "choco,jelly,pen,water:4"}, delimiter = ':')
    @DisplayName("Participants 객체의 사이즈가 입력된 이름의 개수와 같은지 확인한다.")
    void is_same_size_as_the_number_of_names(String names, int expectedSize) {
        // given
        Participants participants = Participants.create(names);

        // when
        int actualSize = participants.size();

        // then
        assertThat(actualSize).isEqualTo(expectedSize);
    }

    @Nested
    @DisplayName("참여자 찾기 테스트")
    class FindParticipantsTest {

        private Participants participants;

        @BeforeEach
        void setUp() {
            final String participantNames = "pobi,honux,crong,jk";
            participants = Participants.create(participantNames);
        }

        @ParameterizedTest
        @ValueSource(strings = {"pobi", "honux", "crong", "jk"})
        @DisplayName("요청된 내용이 참여자에 포함되면, 참여자가 담긴 컬렉션을 얻는다.")
        void gets_some_participants_if_request_content_is_included_in_participants(String requestContent) {
            Participant expectedParticipant = Participant.create(requestContent);

            List<Participant> actualParticipant = participants.findParticipants(requestContent);

            assertThat(actualParticipant).containsExactly(expectedParticipant);
        }

        @Test
        @DisplayName("요청된 이름이 모든 참가자를 가리키는 요청 키이면, 모든 참가자를 얻는다.")
        void gets_all_participants_if_request_content_is_same_with_all_request_key() {
            String requestAll = "all";
            List<Participant> expectedAllParticipants = participants.getParticipants();

            List<Participant> actualAllParticipants = participants.findParticipants(requestAll);

            assertThat(actualAllParticipants).isEqualTo(expectedAllParticipants);
        }
    }
}

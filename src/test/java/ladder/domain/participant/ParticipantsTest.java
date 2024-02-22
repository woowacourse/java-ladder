package ladder.domain.participant;

import ladder.exception.participant.InvalidParticipantsCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParticipantsTest {
    @Test
    @DisplayName("참가자들에게 필요한 사다리 너비를 계산한다.")
    void getParticipantsCountTest() {
        // given
        List<String> names = List.of("mia", "pota", "dora");
        Participants participants = new Participants(names);

        // when
        int count = participants.getNecessaryLadderWidth();

        // then
        assertEquals(2, count);
    }

    @ParameterizedTest
    @MethodSource("getInvalidParticipantsNames")
    @DisplayName("참가자 수가 1명 이하일 경우 예외가 발생한다.")
    void checkParticipantsCountTest(List<String> names) {
        // given & when
        assertThatThrownBy(() -> new Participants(names))
                .isInstanceOf(InvalidParticipantsCountException.class);
    }

    static Stream<List<String>> getInvalidParticipantsNames() {
        return Stream.of(List.of("mia"), List.of());
    }
}

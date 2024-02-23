package ladder.domain.participant;

import ladder.exception.participant.InvalidParticipantsCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ParticipantsTest {
    @Test
    @DisplayName("참가자들에게 필요한 사다리 너비를 계산한다.")
    void getParticipantsCountTest() {
        // given
        final List<String> names = List.of("mia", "pota", "dora");
        final Participants participants = new Participants(names);

        // when
        final int count = participants.getNecessaryLadderWidth();

        // then
        assertThat(count).isEqualTo(2);
    }

    @ParameterizedTest
    @MethodSource("getInvalidParticipantsNames")
    @DisplayName("참가자 수가 1명 이하일 경우 예외가 발생한다.")
    void checkParticipantsCountTest(final List<String> names) {
        // given & when
        assertThatThrownBy(() -> new Participants(names))
                .isInstanceOf(InvalidParticipantsCountException.class);
    }

    static Stream<List<String>> getInvalidParticipantsNames() {
        return Stream.of(List.of("mia"), List.of());
    }
}

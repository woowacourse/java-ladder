package ladder.domain.participant;

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
    @DisplayName("참가자 수를 조회한다.")
    void getParticipantsCountTest() {
        // given
        List<String> names = List.of("mia", "pota", "dora");
        Participants participants = new Participants(names);

        // when
        int count = participants.getCount();

        // then
        assertEquals(3, count);
    }

    @ParameterizedTest
    @MethodSource("getInvalidParticipantsNames")
    @DisplayName("참가자 수가 1명 이하일 경우 예외가 발생한다.")
    void checkParticipantsCountTest(List<String> names) {
        // given & when
        assertThatThrownBy(() -> new Participants(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<List<String>> getInvalidParticipantsNames() {
        return Stream.of(List.of("mia"), List.of());
    }
}

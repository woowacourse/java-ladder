package ladder.domain.participant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
}

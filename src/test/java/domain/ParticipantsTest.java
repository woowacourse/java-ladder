package domain;

import domain.Collection.Participant;
import domain.Collection.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {
    @Test
    @DisplayName("특정 인덱스의 참여자를 가져올 수 있다.")
    void getParticipantAtIndexTest(){
        Participants participants = Participants.of(List.of("echo", "modi", "neo"));
        assertThat(participants.get(0)).isEqualTo(Participant.from("echo"));
    }
}

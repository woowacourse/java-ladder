package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ParticipantsTest {
    @Test
    @DisplayName("특정 인덱스의 참여자를 가져올 수 있다.")
    void getParticipantAtIndexTest(){
        Participants participants = new Participants();
        participants.add(new Participant("echo"));
        participants.add(new Participant("modi"));
        participants.add(new Participant("neo"));
        assertThat(participants.get(0).getName()).isEqualTo("echo");
    }
}

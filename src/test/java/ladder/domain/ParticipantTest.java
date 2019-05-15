package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParticipantTest {
    @Test
    public void 참가자생성(){
        assertThrows(IllegalArgumentException.class, ()->{
           new Participant("abcdef");
        });
    }
}
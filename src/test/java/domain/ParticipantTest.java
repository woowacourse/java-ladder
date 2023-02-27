package domain;

import domain.Collection.Participant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ParticipantTest {
    @Test
    @DisplayName("이름이 네 글자인 참가자는 정상적으로 생성되어야한다.")
    void participantNameLengthSuccessTest() {
        String name = "echo";
        assertDoesNotThrow(() -> Participant.from(name));
    }
    
    @Test
    @DisplayName("이름이 여섯 글자인 참가자는 예외를 발생시켜야한다.")
    void participantNameLengthFailTest() {
        String name = "echo11";
        assertThatThrownBy(() -> Participant.from(name)).isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    @DisplayName("이름이 공백인 참가자는 예외를 발생시켜야한다.")
    void participantNameLengthFailTest2() {
        String name = "  ";
        assertThatThrownBy(() -> Participant.from(name)).isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void checkEmptyNameTest() {
        String input = "echo,,echo2";
        String[] names = input.split(",");
    }
    
    @Test
    @DisplayName("이름이 같은 참가자 객체는 같은 객체이다.")
    void checkParticipantEqualityTest() {
        Participant echo = Participant.from("echo");
        Participant echo2 = Participant.from("echo");
        assertThat(echo).isEqualTo(echo2);
    }
}

package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParticipantTest {

    @DisplayName("참가자를 오른쪽으로 이동시키면 위치가 1증가한다.")
    @Test
    void moveRight() {
        Participant participant = new Participant(new Name("pobi"));
        participant.moveRight();
        Assertions.assertThat(participant.getPosition()).isEqualTo(new Position(1));
    }

    @DisplayName("참가자를 왼쪽으로 이동시키면 위치가 1감소한다.")
    @Test
    void moveLeft() {
        Participant participant = new Participant(new Name("pobi"), new Position(1));
        participant.moveLeft();
        Assertions.assertThat(participant.getPosition()).isEqualTo(new Position(0));
    }
}

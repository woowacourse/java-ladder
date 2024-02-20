package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParticipantTest {
    @Test
    void 참여자_이름이_다섯글자를_넘으면_예외가_발생한다() {
        String name = "엘라릴리애쉬";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Participant(name));
    }
}

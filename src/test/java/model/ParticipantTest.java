package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParticipantTest {
    @Test
    void 참여자_이름이_다섯글자를_넘으면_예외가_발생한다() {
        String name = "엘라릴리애쉬";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Participant(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 참여자_이름이_빈값_혹은_공백이면_예외가_발생한다(String name) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Participant(name));
    }
}

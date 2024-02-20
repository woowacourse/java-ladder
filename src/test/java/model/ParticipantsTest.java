package model;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParticipantsTest {
    @Test
    void 참여자가_두명_미만이면_예외가_발생한다() {
        List<String> names = List.of("엘라");
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Participants(names));
    }
}

package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ExecutionResultTest {
    @Test
    void 실행_결과_개수가_참여할_사람_수만큼_없으면_예외가_발생한다() {
        Participants participants = new Participants(List.of("엘라", "애쉬"));

        assertAll(
                () -> assertThatThrownBy(
                        () -> new ExecutionResult(List.of("꽝"), participants.getParticipantsSize()))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(
                        () -> new ExecutionResult(List.of("꽝", "5000", "꽝"), participants.getParticipantsSize()))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}

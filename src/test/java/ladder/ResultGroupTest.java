package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResultGroupTest {
    ParticipantGroup participantGroup;

    @BeforeEach
    void setUp() {
        participantGroup = new ParticipantGroup(Arrays.asList("1","2","3"));
    }

    @Test
    void 참가자_수와_결과_수가_같은_경우() {
        ResultGroup resultGroup = new ResultGroup(participantGroup,
                Arrays.asList(new Result("꽝"), new Result("1000"), new Result("꽝")));
        assertThat(resultGroup).isEqualTo(new ResultGroup(participantGroup,
                Arrays.asList(new Result("꽝"), new Result("1000"), new Result("꽝"))));
    }

    @Test
    void 참가자_수와_결과_수가_다른_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ResultGroup(participantGroup,
                    Arrays.asList(new Result("꽝"), new Result("1000")));
        });
    }
}

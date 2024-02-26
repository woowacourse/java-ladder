package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ResultInterestedPersonTest {
    @Test
    void 결과를_보고_싶은_사람이_참여한_사람이_아니면_예외가_발생한다() {
        List<String> resultInterestedName = List.of("릴리");
        List<String> participantsNames = List.of("엘라", "애쉬");
        assertThatThrownBy(() -> new ResultInterestedName(resultInterestedName, participantsNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    }
}

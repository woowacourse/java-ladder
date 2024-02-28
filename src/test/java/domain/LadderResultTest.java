package domain;

import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderResultTest {

    @DisplayName("이름을 입력받을 경우 저장된 결과를 반환한다.")
    @Test
    void returnCorrectWinning() {
        LadderResult ladderResult = new LadderResult(Map.of(
                "사람1",
                "보상1",
                "사람2",
                "보상2"
        ));
        Assertions.assertThat(ladderResult.getWinning("사람1"))
                .isEqualTo(List.of("보상1"));
    }
}

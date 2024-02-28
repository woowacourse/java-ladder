package domain;

import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderResultTest {

    private LadderResult ladderResult;

    @BeforeEach
    void setLadderResult() {
        ladderResult = new LadderResult(Map.of(
                "사람1",
                "보상1",
                "사람2",
                "보상2"
        ));
    }

    @DisplayName("이름을 입력받을 경우 저장된 결과를 반환한다.")
    @Test
    void returnCorrectWinning() {
        Assertions.assertThat(ladderResult.getWinning("사람1"))
                .isEqualTo(List.of("보상1"));
    }

    @DisplayName("저장되지 않은 이름을 입력받을 경우 예외를 발생한다.")
    @Test
    void notSavedNameTest() {
        Assertions.assertThatThrownBy(() -> ladderResult.getWinning("사람아님"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력되지 않은 사용자명입니다.");
    }

    @DisplayName("'all'을 입력받을 경우 전체 결과를 반환한다.")
    @Test
    void returnAllResult() {
        Assertions.assertThat(ladderResult.getWinning("all"))
                .isEqualTo(List.of(
                        "사람1 : 보상1",
                        "사람2 : 보상2"
                ));
    }
}

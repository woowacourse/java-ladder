package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameResultsTest {
    @DisplayName("결과를 보고 싶은 사람의 이름이 all이나 입력했던 사용자 중에 없는 이름이면 예외를 던진다.")
    @Test
    void requestResultByUndefined() {
        UserNames userNames = UserNames.from(List.of("liv1", "liv2"));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new GameResults(userNames, "liv3"))
                .withMessage("존재하지 않는 참여자입니다.");
    }
}

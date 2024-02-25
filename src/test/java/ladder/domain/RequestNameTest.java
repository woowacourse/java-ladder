package ladder.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RequestNameTest {
    @DisplayName("입력 받은 결과를 보고 싶은 사람이 all 혹은 참여자가 아니면 예외를 던진다.")
    @Test
    void createRequestNameByInvalidMessage() {
        UserNames userNames = UserNames.from(List.of("a", "b"));

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new RequestName("c", userNames))
                .withMessage("존재하지 않는 참여자입니다.");
    }
}

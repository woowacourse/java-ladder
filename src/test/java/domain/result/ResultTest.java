package domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ResultTest {
    @Nested
    @DisplayName("실행 결과 저장 테스트")
    class MoveUserTest {
        @DisplayName("result에 user와 prize가 올바르게 저장되었는지 확인한다.")
        @Test
        void shouldSuccessSaveResult() {
            Result result = new Result(new HashMap<>());
            String userName = "test";
            String prizeName = "꽝";
            saveResult(userName, prizeName);
            assertThat(result.getResult().get(userName)).isEqualTo(prizeName);
        }
    }
}

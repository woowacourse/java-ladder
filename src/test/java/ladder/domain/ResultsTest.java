package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultsTest {

    @Test
    @DisplayName("실행 결과의 갯수가 참여하는 인원과 같지 않으면 예외가 발생한다.")
    void create_notEqualsPlayersCount() {
        // expect
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Results(createResults(), 5))
                .withMessage("[ERROR] 실행 결과의 갯수와 참여할 사람이 같아야 합니다.");
    }

    @Test
    @DisplayName("실행 결과가 정상적으로 생성되어야 한다.")
    void create_success() {
        // expect
        assertThatNoException()
                .isThrownBy(() -> new Results(createResults(), 4));
    }

    private static List<Result> createResults() {
        return List.of(new Result("꽝"),
                new Result("5000"),
                new Result("꽝"),
                new Result("3000"));
    }
}

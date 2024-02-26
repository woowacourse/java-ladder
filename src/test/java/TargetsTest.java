import domain.PlayerCount;
import domain.Target;
import domain.Targets;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TargetsTest {
    @DisplayName("참여자의 수와 실행 결과의 수가 일치하지 않으면 예외를 발생시킨다.")
    @Test
    void notEqual() {
        Assertions.assertThatThrownBy(() -> Targets.from(List.of("1000", "2000", "3000"), PlayerCount.from(2)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("해당 순서의 실행 결과를 리턴한다.")
    @Test
    void getTarget() {
        Targets targets = Targets.from(List.of("1000", "2000", "3000"), PlayerCount.from(3));

        Assertions.assertThat(targets.getPrize(1)).isEqualTo(new Target("2000"));
    }
}

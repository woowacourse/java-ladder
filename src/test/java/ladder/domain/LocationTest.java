package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import ladder.domain.player.Location;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LocationTest {
    @DisplayName("입력된 인자를 value로 가진다.")
    @Test
    void locationConstructTest() {
        Location location = new Location(1);

        assertThat(location.value()).isEqualTo(1);
    }

    @DisplayName("0 미만의 위치를 입력하면 예외가 발생한다.")
    @Test
    void invalidLocationTest() {
        assertThatThrownBy(() -> new Location(-1))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("위치 입력 코드에 문제가 있습니다: %d".formatted(-1)
                        + "\n사용자 입력 후 발생한 경우: Players의 생성자에서 Player를 생성할 때 문제가 있을 확률이 높음."
                        + "\n모든 결과 입력 후 발생한 경우: Ladder의 findResultLocation에 문제가 있을 확률이 높음.");
    }
}

package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderRungTest {
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void 가로대가_연결되면_true를_반환하고_연결되지_않으면_false를_반환한다(boolean isConnected) {
        // given
        LadderRung ladderRung = LadderRung.create(() -> isConnected);

        // when & then
        assertThat(ladderRung.isConnected()).isEqualTo(isConnected);
    }
}

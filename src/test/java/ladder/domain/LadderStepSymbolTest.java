package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderStepSymbolTest {

    @DisplayName("Boolean 값을 Step Symbol에 맞춰 변환한다.")
    @Test
    void changeStepSymbol() {
        String ladderStepSymbol = LadderStepSymbol.changeStatusToSymbol(true);

        assertThat(ladderStepSymbol).isEqualTo("-----");
    }
}

package ladder.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RungSymbolTest {

    @DisplayName("Boolean 값을 rung Symbol에 맞춰 변환한다.")
    @Test
    void changeRungSymbolTrueTest() {
        String ladderRungSymbol = RungSymbol.changeStatusToSymbol(true);

        assertThat(ladderRungSymbol).isEqualTo("-----");
    }

    @DisplayName("Boolean 값을 rung Symbol에 맞춰 변환한다.")
    @Test
    void changeRungSymbolFalseTest() {
        String ladderRungSymbol = RungSymbol.changeStatusToSymbol(false);

        assertThat(ladderRungSymbol).isEqualTo("     ");
    }

}

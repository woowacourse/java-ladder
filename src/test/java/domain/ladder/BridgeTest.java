package domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class BridgeTest {

    private static final String TRUE_MESSAGE = "-----";
    private static final String FALSE_MESSAGE = "     ";

    @Test
    @DisplayName("사다리의 다리가 존재하면 '-----'를 출력한다.")
    void getBridgeTrueMessage() {
        boolean flag = true;
        assertThat(Bridge.getBridge(flag).getMessage()).isEqualTo(TRUE_MESSAGE);
    }

    @Test
    @DisplayName("사다리의 다리가 존재하지 않으면 '     '를 출력한다.")
    void getBridgeFalseMessage() {
        boolean flag = false;
        assertThat(Bridge.getBridge(flag).getMessage()).isEqualTo(FALSE_MESSAGE);
    }
}

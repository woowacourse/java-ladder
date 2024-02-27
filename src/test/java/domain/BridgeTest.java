package domain;

import static domain.Bridge.BLANK;
import static domain.Bridge.EXIST;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest {

    @DisplayName("다리가 존재하면 true를 반환한다")
    @Test
    public void isExist() {
        assertThat(EXIST.isExist()).isTrue();
    }

    @DisplayName("다리가 존재하지 않으면 false를 반환한다")
    @Test
    public void isEmpty() {
        assertThat(BLANK.isExist()).isFalse();
    }
}

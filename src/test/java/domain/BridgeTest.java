package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest {

    @DisplayName("다리가 존재하면 isExist가 true를 반환한다")
    @Test
    public void isExist() {
        assertThat(Bridge.EXIST.isExist()).isTrue();
        assertThat(Bridge.BLANK.isExist()).isFalse();
    }

    @DisplayName("다리가 존재지 않으면 isNotExist가 true를 반환한다")
    @Test
    public void isNotExist() {
        assertThat(Bridge.BLANK.isNotExist()).isTrue();
        assertThat(Bridge.EXIST.isNotExist()).isFalse();
    }
}

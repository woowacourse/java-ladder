package model;

import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 플레이어 위치를 Wrapping하는 클래스.
 * 원시타입 데이터의 getter는 테스트하지 않는다.
 */
public class PositionTest {
    @Test
    @DisplayName("Position 객체 생성 성공 테스트")
    void createPositionTest() {
        assertThatNoException().isThrownBy(() -> new Position(1));
    }
}

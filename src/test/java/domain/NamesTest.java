package domain;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NamesTest {
    @DisplayName("입력된 이름들 중복 검증 성공 테스트")
    @Test
    void 중복된_이름_검증_성공_테스트() {
        Assertions.assertDoesNotThrow(() -> {
            new Names(Arrays.asList("a", "b"));
        });
    }

    @DisplayName("입력된 이름들 중복 검증 실패 테스트")
    @Test
    void 중복된_이름_검증_실패_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new Names(Arrays.asList("a", "a"));
                });
    }
}

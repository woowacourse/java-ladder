package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResultItemsTest {
    @Test
    void 상품결과의_수량이_플레이어_수와_맞지_않으면_예외를_처리하는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new ResultItems(Arrays.asList("a,b,c".split(",")), 4));
    }
}

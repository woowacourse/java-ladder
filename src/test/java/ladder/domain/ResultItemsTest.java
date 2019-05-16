package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResultItemsTest {
    @Test
    void 당첨_결과의_수가_플레이어의_수와_다르면_예외를_던져주는지_테스트() {
        assertThrows(IllegalArgumentException.class,
                () -> new ResultItems(Arrays.asList("a,b,c,d".split(",")), 5));
    }
}

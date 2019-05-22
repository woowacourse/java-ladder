package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResultItemTest {
    @Test
    void 아이템_이름의_길이가_5를_넘으면_예외를_던져주는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new ResultItem("dddddd"));
    }

    @Test
    void 아이템_이름의_길이가_null이면_예외를_던져주는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new ResultItem(null));
    }

    @Test
    void 아이템_이름이_공백이면_예외를_던져주는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new ResultItem(" "));
    }
}

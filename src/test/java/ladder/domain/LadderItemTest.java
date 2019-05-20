package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderItemTest {
    @Test
    void 항목_이름이_기준_길이보다_길_때_예외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new LadderItem("qweasd"));
    }

    @Test
    void 항목_이름이_공백으로만_이루어져_있을_때_예외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new LadderItem(" "));
    }

    @Test
    void 항목_이름이_null일_때_예외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new LadderItem(null));
    }
}

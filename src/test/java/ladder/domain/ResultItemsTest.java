package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResultItemsTest {
    @Test
    void 결과Position을_입력받아_해당_위치에_있는_결과항목을_제대로_반환하는지_테스트() {
        ResultItems resultItems = new ResultItems(Arrays.asList("a", "b", "c"), 3);

        assertThat(resultItems.getResultItemAtPositionOf(2)).isEqualTo(new LadderItem("c"));
    }

    @Test
    void item개수가_player수와_다르면_예외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class,
                () -> new ResultItems(Arrays.asList("a, b, c"), 4));
    }
}

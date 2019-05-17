package laddergame.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class SplitterTest {
    @Test
    void 공백을_제대로_제거하여_나누는지_테스트() {
        assertThat(Splitter.splitByComma(" a , b,c "))
                .isEqualTo(Arrays.asList("a", "b", "c"));
    }
}
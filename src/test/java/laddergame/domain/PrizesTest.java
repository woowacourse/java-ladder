package laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class PrizesTest {
    @Test
    void 상품들을_받아서_제대로_생성되는지_확인() {
        final Prizes prizes = new Prizes(Arrays.asList("10", "200"));

        assertThat(new Prizes(Arrays.asList("10", "200"))).isEqualTo(prizes);
    }
}
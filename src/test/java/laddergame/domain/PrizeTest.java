package laddergame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrizeTest {
    @Test
    void create() {
        assertThat(new Prize("a")).isEqualTo(new Prize("a"));
    }

    @Test
    void 상품명이_정확하게_출력되는지_테스트() {
        Prize prize = new Prize("a");
        assertThat(prize.getPrize()).isEqualTo("a");
    }
}

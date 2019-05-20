package laddergame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TagTest {
    @Test
    void 이름을_제대로_조회하는지_확인() {
        assertThat(new Tag("pobi").getName()).isEqualTo("pobi");
    }

    @Test
    void 이름이_null이면_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Tag(null);
        });
    }

    @Test
    void 이름이_공백이면_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Tag("");
        });
    }

    @Test
    void 이름이_5자를_넘어가면_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Tag("aaaaaa");
        });
    }
}
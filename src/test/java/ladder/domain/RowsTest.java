package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class RowsTest {

    @Test
    void 높이가_0보다_크지_않으면_에러() {
        assertThatThrownBy(() -> new Rows(0, 3))
                .hasMessage("높이는 0보다 커댜 합니다");
    }

}

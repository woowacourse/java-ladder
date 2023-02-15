package laddergame.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {
    @Test
    @DisplayName("참여자의 개수보다 하나 적은 사이즈로 리스트 생성 테스트")
    void Should_Success_When_MakeLine() {
        int personCount = 4;
        assertThat(new Line(personCount).getSize()).isEqualTo(personCount - 1);
    }
}

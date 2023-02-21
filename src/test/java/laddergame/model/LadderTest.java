package laddergame.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {
    @Test
    @DisplayName("사다리 생성 테스트")
    void Should_Success_When_MakeLadder() {
        Height height = new Height(3);
        Persons persons = new Persons(List.of("aa", "bb"));
        assertDoesNotThrow(() -> new Ladder(height, persons));
    }

    @Test
    @DisplayName("사다리가 높이만큼 선을 생성하는지 테스트")
    void Should_EqualTo_When_MakeLadder() {
        Height height = new Height(4);
        Persons persons = new Persons(List.of("aa", "bb"));
        assertThat(new Ladder(height, persons).getSize()).isEqualTo(height.getHeight());
    }
}

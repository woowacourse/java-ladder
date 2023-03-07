package laddergame.model.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import laddergame.model.people.People;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {
    @Test
    @DisplayName("사다리 생성 테스트")
    void Should_Success_When_MakeLadder() {
        Height height = new Height(3);
        People people = new People(List.of("aa", "bb"));
        assertDoesNotThrow(() -> new Ladder(height, people));
    }

    @Test
    @DisplayName("사다리가 높이만큼 선을 생성하는지 테스트")
    void Should_EqualTo_When_MakeLadder() {
        Height height = new Height(4);
        People people = new People(List.of("aa", "bb"));
        assertThat(new Ladder(height, people).getHeight()).isEqualTo(height.getHeight());
    }
}

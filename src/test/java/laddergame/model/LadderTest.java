package laddergame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import laddergame.model.Ladder.Height;
import laddergame.model.Ladder.Ladder;

class LadderTest {
    @Test
    @DisplayName("사다리 생성 테스트")
    void Should_Success_When_MakeLadder() {
        Height height = new Height(3);
        Participants participants = new Participants(List.of("aa", "bb"));
        assertDoesNotThrow(() -> new Ladder(height, participants));
    }

    @Test
    @DisplayName("사다리가 높이만큼 선을 생성하는지 테스트")
    void Should_EqualTo_When_MakeLadder() {
        Height height = new Height(4);
        Participants participants = new Participants(List.of("aa", "bb"));
        assertThat(new Ladder(height, participants).getHeight()).isEqualTo(height.getHeight());
    }
}

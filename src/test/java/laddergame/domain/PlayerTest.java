package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayerTest {
    @DisplayName("플레이어 position 기준 왼쪽에 true 가 있으면 position 감소 확인 테스트")
    @Test
    void move_left() {
        Player player = new Player("jena", 1);
        Line line = new Line(3,
                new TestTrueOrFalseGenerator(new ArrayList<>(List.of(true, false))));
        player.move(line.isStep(player.getPosition() - 1), line.isStep(player.getPosition()));
        assertThat(player.getPosition()).isEqualTo(0);
    }

    @DisplayName("플레이어 position 기준 오른쪽에 true 가 있으면 position 증가 확인 테스트")
    @Test
    void move_right() {
        Player player = new Player("jena", 1);
        Line line = new Line(3,
                new TestTrueOrFalseGenerator(new ArrayList<>(List.of(false, true))));
        player.move(line.isStep(player.getPosition() - 1), line.isStep(player.getPosition()));
        assertThat(player.getPosition()).isEqualTo(2);

    }
}

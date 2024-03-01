package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;

import domain.generator.FixedBridgeGenerator;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("사다리를 생성한다")
    @Test
    public void create() {
        Players players = new Players(List.of("pobi", "honux", "crong", "jk"));
        Height height = new Height(5);
        assertThatCode(() -> new Ladder(players, height, new FixedBridgeGenerator()))
                .doesNotThrowAnyException();
    }

    @DisplayName("사용자가 입력한 높이만큼 Line을 가진다")
    @Test
    public void createLinesByHeight() {
        Players players = new Players(List.of("pobi", "honux", "crong", "jk"));
        Height height = new Height(5);
        Ladder ladder = new Ladder(players, height, new FixedBridgeGenerator());

        Map<Integer, Line> lines = ladder.getLines();

        assertThat(lines.size()).isEqualTo(5);
    }

    @DisplayName("플레이어들의 위치를 사다리 높이만큼 계산한다")
    @Test
    public void calculate() {
        Ladder ladder = new Ladder(new Players(List.of("pobi", "honux", "crong", "jk")), new Height(5),
                new FixedBridgeGenerator());
        /*
         0     1     2     3
         |-----|     |-----|
         |-----|     |-----|
         |-----|     |-----|
         |-----|     |-----|
         |-----|     |-----|
         1     0     3     2
         */
        assertAll(
                () -> assertThat(ladder.calculate(0)).isEqualTo(1),
                () -> assertThat(ladder.calculate(1)).isEqualTo(0),
                () -> assertThat(ladder.calculate(2)).isEqualTo(3),
                () -> assertThat(ladder.calculate(3)).isEqualTo(2)
        );
    }
}

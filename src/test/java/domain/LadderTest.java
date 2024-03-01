package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

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

    @DisplayName("생성된 사다리의 결과를 반환한다")
    @Test
    public void getResult() {
        Players players = new Players(List.of("pobi", "honux", "crong", "jk"));
        Prizes prizes = new Prizes(players, List.of("꽝", "5000", "꽝", "3000"));
        Height height = new Height(5);
        Ladder ladder = new Ladder(players, height, new FixedBridgeGenerator());

        Result result = ladder.getResult();

        String pobiResult = result.match("pobi", prizes);
        assertThat(pobiResult).isEqualTo("5000");

        Map<String, String> allResult = result.matchAll(prizes);
        assertThat(allResult).isEqualTo(Map.of(
                "pobi", "5000",
                "honux", "꽝",
                "crong", "3000",
                "jk", "꽝"));
    }
}

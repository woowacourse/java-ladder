package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.RandomBooleanGenerator;

class MapTest {

    @DisplayName("높이와 참가자의 수가 조건에 맞는 경우 사다리를 생성한다.")
    @Test
    void createSuccess() {
        Map map = new Map(new Height("3"), new Weight(3), new RandomBooleanGenerator());
        Assertions.assertThat(map.getLines()).hasSize(3);
    }

    @DisplayName("참가자 수에서 1을 뺀 만큼의 라인을 가진사다리를 만든다.")
    @Test
    void generateMap() {
        Map ladder = new Map(new Height("3"), new Weight(3), () -> true);
        List<Line> lines = ladder.getLines();
        Assertions.assertThat(lines).hasSize(3);
        Assertions.assertThat(lines.get(0).getStatus()).containsExactly(true, false);
        Assertions.assertThat(lines.get(1).getStatus()).containsExactly(true, false);
        Assertions.assertThat(lines.get(2).getStatus()).containsExactly(true, false);
    }
}

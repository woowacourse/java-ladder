package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultTest {
    //플레이어 기준  아이템과 매칭
    // ㅍㄹ레이어의 포지션을 읽고 아이템의 포지션을 읽어 저장한다
    @Test
    @DisplayName("플레이어의 position과 같은 item을 입력한다")
    void shouldSamePositionPlayerAndItemWhenInput() {
        GameResult gameResult = GameResult.generate(Players.generate(List.of("a", "b")),
                Items.generate(List.of("1", "2")));

        Map<String, String> result = gameResult.findResult(new Name("a"));

        assertThat(result).containsEntry("a", "1");
    }

}

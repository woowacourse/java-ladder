package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class ResultsTest {

    @DisplayName("한 플레이어에 대한 결과가 나오면 이에 대한 실행 결과를 저장할 수 있다.")
    @Test
    void resultAddResultTest() {
        Results results = new Results();
        Player player = new Player("kong", 1);
        Prize prize = new Prize("꽝");
        results.addResult(player, prize);
        Map<Player, Prize> result =  results.getResults();
        assertThat(result).hasSize(1)
                .contains(entry(player, prize));
    }

    @DisplayName("실행 결과는 게임을 통해 아직 결과를 구하지 않았다면 false를 반환할 수 있다.")
    @Test
    void resultIsSameSizeToTest1() {
        Results results = new Results();
        assertThat(results.isSameSizeTo(1)).isFalse();
    }

    @DisplayName("실행 결과는 게임을 통해 결과를 구했다면 true를 반환할 수 있다.")
    @Test
    void resultIsSameSizeToTest2() {
        Results results = new Results();
        results.addResult(new Player("kong", 1), new Prize("꽝"));
        assertThat(results.isSameSizeTo(1)).isTrue();
    }
}

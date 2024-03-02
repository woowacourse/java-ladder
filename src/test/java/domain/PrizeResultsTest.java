package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeResultsTest {

    /*
    wiib    pobi    haha
        |------|      |
        |------|      |
        |------|      |
        꽝     당첨    꽝
     */
    private PrizeResults init() {
        return PrizeResults.of(
                new Players(List.of("wiib", "pobi", "haha")),
                Prizes.of(List.of("꽝", "당첨", "꽝"), 3),
                new Ladder(3, new Height(3), new FixedBooleanGenerator(true)));
    }

    @Test
    @DisplayName("Players, Prizes, Ladder를 통해 생성한다.")
    void createSuccess() {
        assertThatCode(this::init
        ).doesNotThrowAnyException();

    }

    @Test
    @DisplayName("all 또는 사용자 이름과 다를 경우, 예외를 발생한다.")
    void checkOperateValidation() {
        PrizeResults prizeResults = init();

        assertThatCode(() -> prizeResults.getByOperator("atom"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("all이면 전체 결과를 도출한다.")
    void getALL() {
        PrizeResults prizeResults = init();

        Map<Player, Prize> allActual = prizeResults.getByOperator("all");
        Map<Player, Prize> allExpected = new LinkedHashMap<>();
        allExpected.put(new Player("wiib"), new Prize("당첨"));
        allExpected.put(new Player("pobi"), new Prize("꽝"));
        allExpected.put(new Player("haha"), new Prize("꽝"));

        assertThat(allActual).containsExactlyEntriesOf(allExpected);
    }

    @Test
    @DisplayName("사용자 이름을 입력하면 그 사용자의 결과를 도출한다.")
    void getPlayerResult() {
        PrizeResults prizeResults = init();

        Map<Player, Prize> wiibResultActual = prizeResults.getByOperator("wiib");
        Map<Player, Prize> wiibResultExpected = new LinkedHashMap<>();
        wiibResultExpected.put(new Player("wiib"), new Prize("당첨"));

        assertThat(wiibResultActual).containsExactlyEntriesOf(wiibResultExpected);
    }
}


package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.TestLineItemGenerator;
import view.LineItem;
import java.util.List;

public class PlayerResultsTest {

    private static Prizes prizes;
    private static PlayerResults playerResults;

    @BeforeAll
    public static void setPlayerNames() {
        TestLineItemGenerator lineItemGenerator = new TestLineItemGenerator(LineItem.CONNECTED);
        List<String> playerNames = List.of("pobi", "honux", "crong", "jk");
        List<String> prizeInput = List.of("꽝", "5000", "꽝", "3000");

        int playerCount = 4;
        Players players = new Players(playerNames);
        Ladder ladder = Ladder.of(new Height("5"), playerCount, lineItemGenerator);
        prizes = new Prizes(prizeInput, playerCount);
        playerResults = PlayerResults.of(players, ladder, prizes);
    }

    @DisplayName("참여자의 실행 결과를 반환한다.")
    @Test
    void returnPlayerResult() {
        // when
        String playerName = "pobi";
        Prize prize = playerResults.findPlayerResultByPlayer(playerName);

        // then
        assertThat(prize.getPrize()).isEqualTo(prizes.findPrizeByPosition(1).getPrize());
    }

    @DisplayName("참여자 목록에 없는 이름으로 조회하면 예외가 발생한다.")
    @Test
    void occurExceptionIfNotExistedName() {
        // when & then
        String playerName = "냥인";
        assertThatThrownBy(() -> playerResults.findPlayerResultByPlayer(playerName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여자 목록에 없는 이름입니다.");
    }

    @DisplayName("이름에 해당하는 실행 결과가 있는지 확인한다.")
    @ParameterizedTest
    @CsvSource({"crong, true", "냥인, false"})
    void checkHasResultOfName(String name, boolean expected) {
        // when
        boolean result = playerResults.hasResult(name);

        // then
        assertThat(result).isEqualTo(expected);
    }
}

package laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameResultTest {
    @Test
    void 리퀘스트가_올바르게_들어오지_않을때_테스트() {
        Players testPlayers = new Players("pobi, kjm, brown");
        Prizes testPrizes = new Prizes(3,"win, winwin, winwinwin");
        String request = "jason";
        assertThrows(IllegalArgumentException.class, ()-> new GameResult(request, testPlayers, testPrizes));
    }

    @Test
    void 게임결과_제대로_생성되는지_테스트() {
        Players testPlayers = new Players("pobi,kjm,brown");
        Prizes testPrizes = new Prizes(3,"win,winwin,winwinwin");
        String testRequest = "pobi";

        GameResult result = new GameResult(testRequest, testPlayers, testPrizes);

        String testString1 = "pobi : win\n";
        String testString2 = "kjm : winwin\n";
        String testString3 = "brown : winwinwin\n";

        List<String> checkList = Arrays.asList(testString1, testString2, testString3);

        assertThat(result.getResults()).isEqualTo(checkList);
        assertThat(result.getRequestValue().getRequest()).isEqualTo("pobi");

    }
}

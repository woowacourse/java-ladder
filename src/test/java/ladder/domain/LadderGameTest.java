package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderGameTest {
    LadderGame ladderGame;
    List<Player> players;
    List<DrawResult> drawResults;
    Ladder ladder;

    @BeforeEach
    void setUp() {
        Player player1 = new Player("pobi");
        Player player2 = new Player("crong");
        Player player3 = new Player("zino");

        DrawResult drawResult1 = new DrawResult("짜장");
        DrawResult drawResult2 = new DrawResult("짬뽕");
        DrawResult drawResult3 = new DrawResult("탕수육");

        players = Arrays.asList(player1, player2, player3);
        drawResults = Arrays.asList(drawResult1, drawResult2, drawResult3);
        Line line1 = new Line(Arrays.asList(true, false));
        Line line2 = new Line(Arrays.asList(false, false));
        Line line3 = new Line(Arrays.asList(true, false));
        ladder = new Ladder(Arrays.asList(line1, line2, line3));
        ladderGame = new LadderGame(players, drawResults, ladder);
        ladderGame.play();
    }

    @Test
    void 참여_인원과_결과의_수_동일_테스트() {
        System.out.println(ladderGame.toString());
        drawResults = Arrays.asList(new DrawResult("0"), new DrawResult("1000"), new DrawResult("10000"));
        assertThrows(IllegalArgumentException.class, () -> new LadderGame(players, drawResults, ladder));
    }

    @Test
    void 전체_결과_출력_테스트() {
        assertThat(ladderGame.drawResult("all")).isEqualTo("zino : 탕수육\n" +
                "pobi : 짜장\n" +
                "crong : 짬뽕\n");

    }

    @Test
    void 플레이어_결과_출력_테스트() {
        assertThat(ladderGame.drawResult("zino")).isEqualTo("zino : 탕수육\n" +
                "pobi : 짜장\n" +
                "crong : 짬뽕\n");

    }
}

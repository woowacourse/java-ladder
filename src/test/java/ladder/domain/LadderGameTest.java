package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {
    private LadderGame ladderGame;
    private List<Player> players;
    private List<DrawResult> drawResults;
    private Ladder ladder;
    private GameResult gameResult;

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

        Line line1 = new Line(Arrays.asList(new Point(false, 0, true)
                                            , new Point(true,1,false)
                                            , new Point(false, 2, false)));
        Line line2 = new Line(Arrays.asList(new Point(false, 0, false)
                                            , new Point(false,1,false)
                                            , new Point(false, 2, false)));
        Line line3 = new Line(Arrays.asList(new Point(false, 0, true)
                                            , new Point(true,1,false)
                                            , new Point(false, 2, false)));


        ladder = new Ladder(Arrays.asList(line1, line2, line3));
        ladderGame = new LadderGame(ladder);
        gameResult = ladderGame.play(players, drawResults);
    }

    @Test
    void 참여_인원과_결과의_수_동일_테스트() {
        System.out.println(ladderGame.toString());
        drawResults = Arrays.asList(new DrawResult("1000"), new DrawResult("10000"));
        assertThrows(IllegalArgumentException.class, () -> new LadderGame(ladder).play(players, drawResults));
    }

    @Test
    void 전체_결과_출력_테스트() {
        assertThat(gameResult.getResult("all")).isEqualTo("pobi : 짜장\n" +
                "crong : 짬뽕\n" +
                "zino : 탕수육\n");

    }

    @Test
    void 플레이어_결과_출력_테스트() {
        assertThat(gameResult.getResult("zino")).isEqualTo("탕수육");

    }
}

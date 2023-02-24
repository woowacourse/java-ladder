package domain.service;

import domain.model.Ladder;
import domain.model.Layer;
import domain.model.Player;
import domain.model.Players;
import domain.vo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderGameTest {

    Players players;
    Ladder ladder;
    Results results;

    @BeforeEach
    void setUp() {
        Player player1 = new Player(new Name("p1"));
        Player player2 = new Player(new Name("p2"));
        Player player3 = new Player(new Name("p3"));
        Player player4 = new Player(new Name("p4"));
        players = new Players(List.of(player1, player2, player3, player4));

        ladder = new Ladder(new Height(3), new Width(4));

        Layer layer1 = new Layer();
        layer1.makeLine(true);
        layer1.makeLine(false);
        layer1.makeLine(true);

        Layer layer2 = new Layer();
        layer2.makeLine(false);
        layer2.makeLine(true);
        layer2.makeLine(false);

        Layer layer3 = new Layer();
        layer3.makeLine(true);
        layer3.makeLine(false);
        layer3.makeLine(true);

        ladder.addLayer(layer1);
        ladder.addLayer(layer2);
        ladder.addLayer(layer3);

        Result result1 = new Result("꽝");
        Result result2 = new Result("1000");
        Result result3 = new Result("2000");
        Result result4 = new Result("3000");

        results = new Results(List.of(result1, result2, result3, result4));
    }

    @ParameterizedTest(name = "{0}이 사다리 높이 만큼 이동했을 때의 위치는 ({1}, 3)")
    @CsvSource(value = {"p1:3", "p2:1", "p3:2", "p4:0"}, delimiter = ':')
    void play(String name, int xPosition) {
        LadderGame ladderGame = new LadderGame(ladder, players, results);

        ladderGame.play();

        players = ladderGame.getPlayers();

        Player player = players.findByName(new Name(name));

        assertThat(player.getXPosition()).isEqualTo(xPosition);
        assertThat(player.getYPosition()).isEqualTo(3);
    }


    @ParameterizedTest(name = "결과를 원하는 {0}번 째 player의 결과는 {1}")
    @CsvSource(value = {"0:3000", "1:1000", "2:2000", "3:꽝"}, delimiter = ':')
    void resultsByNames(int index, String expected) {
        LadderGame ladderGame = new LadderGame(ladder, players, results);

        ladderGame.play();
        Name p1 = new Name("p1");
        Name p2 = new Name("p2");
        Name p3 = new Name("p3");
        Name p4 = new Name("p4");
        Names wantResult = new Names(List.of(p1, p2, p3, p4));
        Results resultsByNames = ladderGame.resultsByNames(wantResult);

        assertThat(resultsByNames.get(index).getValue()).isEqualTo(expected);
    }

    @ParameterizedTest(name = "결과를 원하는 {0}번 째 player의 결과는 {1}")
    @CsvSource(value = {"0:2000", "1:꽝"}, delimiter = ':')
    void resultsByNames2(int index, String expected) {
        LadderGame ladderGame = new LadderGame(ladder, players, results);

        ladderGame.play();
        Names wantResult = new Names(List.of(new Name("p3"), new Name("p4")));
        Results resultsByNames = ladderGame.resultsByNames(wantResult);

        assertThat(resultsByNames.get(index).getValue()).isEqualTo(expected);
    }
}
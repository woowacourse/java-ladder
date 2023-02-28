package domain.service;

import domain.model.Ladder;
import domain.model.Layer;
import domain.model.Players;
import domain.vo.Results;
import dto.ViewResultParameter;
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
        players = Players.from(List.of("p1", "p2", "p3", "p4"));

        ladder = new Ladder(3, 4);

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

        results = Results.from(List.of("꽝", "1000", "2000", "3000"));
    }

    @ParameterizedTest(name = "{0}이 사다리 높이 만큼 이동했을 때의 위치는 ({1}, 3)")
    @CsvSource(value = {"p1:3", "p2:1", "p3:2", "p4:0"}, delimiter = ':')
    void play(String name, int xPosition) {
        LadderGame ladderGame = new LadderGame(ladder, players, results);

        ladderGame.play();

        players = ladderGame.getPlayers();

        int order = players.orderByName(name);

        assertThat(order).isEqualTo(xPosition);
    }


    @ParameterizedTest(name = "결과를 원하는 {0}번 째 player의 결과는 {1}")
    @CsvSource(value = {"0:3000", "1:1000", "2:2000", "3:꽝"}, delimiter = ':')
    void resultsByNames(int index, String expected) {
        LadderGame ladderGame = new LadderGame(ladder, players, results);

        ladderGame.play();
        List<String> viewers = List.of("p1", "p2", "p3", "p4");
        ViewResultParameter resultsByNames = ladderGame.viewersAndResults(viewers);

        assertThat(resultsByNames.getViewResult().get(index)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "결과를 원하는 {0}번 째 player의 결과는 {1}")
    @CsvSource(value = {"0:2000", "1:꽝"}, delimiter = ':')
    void resultsByNames2(int index, String expected) {
        LadderGame ladderGame = new LadderGame(ladder, players, results);

        ladderGame.play();
        List<String> viewers = List.of("p3", "p4");
        ViewResultParameter resultsByNames = ladderGame.viewersAndResults(viewers);

        assertThat(resultsByNames.getViewResult().get(index)).isEqualTo(expected);
    }
}
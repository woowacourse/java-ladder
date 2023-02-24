package domain.service;

import static org.assertj.core.api.Assertions.assertThat;

import domain.model.Ladder;
import domain.model.Layer;
import domain.model.Player;
import domain.model.Players;
import domain.model.Result;
import domain.model.Results;
import domain.vo.Height;
import domain.vo.Width;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameSupportTest {

    private final LadderGameSupport ladderGameSupport = new LadderGameSupport(() -> true);

    @Test
    @DisplayName("사다리 생성을 테스트한다.")
    public void makeLadderSuccessTest() {
        //given
        Height height = new Height(5);
        Width width = new Width(5);

        //when
        Ladder ladder = ladderGameSupport.makeLadder(height, width);

        //then
        assertThat(ladder.getLayers().size()).isEqualTo(height.getValue());
    }

    @Test
    @DisplayName("모든 위치에서 사다리를 탄 결과를 반환함을 테스트한다.")
    public void makeResultBoardSuccessTest() {
        //given
        Height height = new Height(4);
        Width width = new Width(5);
        List<Layer> layers = IntStream.range(0, height.getValue())
            .mapToObj(index -> new Layer(new ArrayList<>(), () -> true))
            .collect(Collectors.toList());
        Ladder ladder = new Ladder(height, width, layers);
        ladder.makeLineInLayers();
        List<String> mockLetters = new ArrayList<>();
        for (int i = 0; i < width.getValue() + 1; i++) {
            mockLetters.add(i + "test");
        }
        Players players = new Players(mockLetters);
        Results results = new Results(mockLetters);

        //when
        Map<Player, Result> resultBoard = ladderGameSupport.makeResultBoard(ladder, players, results);

        //then
        for (int i = 0; i < width.getValue(); i++) {
            assertThat(resultBoard.get(players.getPlayers().get(i))).isEqualTo(results.getResults().get(i));
        }
    }
}
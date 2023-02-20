package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.LineGenerator;

import java.util.ArrayList;
import java.util.List;

public class GameTest {

    @Test
    @DisplayName("Game 객체 생성 성공 테스트")
    void createGameTest(){
        Names names = new Names("pobi,honux,crong");
        LadderResult result = new LadderResult("꽝,10000,꽝",names.getNamesSize());
        LadderHeight height = new LadderHeight(5);
        Ladder ladder = new Ladder(names.getNamesSize(), height, new LineGenerator());

        Assertions.assertThatNoException().isThrownBy(
                () -> new Game(names,result,height,ladder)
        );
    }

    @ParameterizedTest(name = "Game 테스트 name = {0}")
    @CsvSource(value = {"pobi:꽝", "honux:꽝","crong:10000"}, delimiter = ':')
    void createGameStartTest(String input, String prize){
        Names names = new Names("pobi,honux,crong");
        LadderResult result = new LadderResult("꽝,10000,꽝",names.getNamesSize());
        LadderHeight height = new LadderHeight(1);

        List<Boolean> randomLine = new ArrayList<>(List.of(false,true));
        Ladder ladder = new Ladder(names.getNamesSize(), height,
                new LineTest.TestLineGenerator(randomLine));

        Game game = new Game(names,result,height,ladder);

        Assertions.assertThat(game.getPrizeResult(input)).isEqualTo(prize);
    }
}

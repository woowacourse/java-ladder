package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.LineGenerator;

import java.util.ArrayList;
import java.util.List;

public class GameTest {

    private static Names names;
    private static LadderResult result;
    private static LadderHeight height;
    private static List<Boolean> randomLine;
    private static Ladder ladder;

    @BeforeEach
    void beforeEach(){
        names = new Names("pobi,honux,crong");
        result = new LadderResult("꽝,10000,꽝",names.getNamesSize());
        height = new LadderHeight(1);
        randomLine = new ArrayList<>(List.of(false,true));
        ladder  = new Ladder(names.getNamesSize(), height,
                new LineTest.TestLineGenerator(randomLine));
    }

    @Test
    @DisplayName("Game 객체 생성 성공 테스트")
    void createGameTest(){
        Ladder ladder = new Ladder(names.getNamesSize(), height, new LineGenerator());

        Assertions.assertThatNoException().isThrownBy(
                () -> new Game(names,result,height,ladder)
        );
    }

    @ParameterizedTest(name = "Game 결과 호출 성공 테스트 name = {0}")
    @CsvSource(value = {"pobi:꽝", "honux:꽝","crong:10000"}, delimiter = ':')
    void getGamePrizeTest(String input, String prize){
        Game game = new Game(names,result,height,ladder);

        Assertions.assertThat(game.getPrizeIndividualPlayer(input)).isEqualTo(prize);
    }

    @Test
    @DisplayName("Game 결과 전체 호출 성공 테스트")
    void getGamePrizeAllTest(){
        Game game = new Game(names,result,height,ladder);

        String result = "crong : 10000"+System.lineSeparator()+
                "pobi : 꽝"+System.lineSeparator()+
                "honux : 꽝"+System.lineSeparator();

        Assertions.assertThat(game.getPrizePlayers()).isEqualTo(result);
    }
}

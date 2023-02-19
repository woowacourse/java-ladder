package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    @DisplayName("Game 객체 생성 성공 테스트")
    void createGameTest(){
        Names names = new Names("pobi,honux,crong");
        LadderResult result = new LadderResult("꽝,10000,꽝",names.getNamesSize());
        LadderHeight height = new LadderHeight(5);
        Ladder ladder = new Ladder(names.getNamesSize(), height);

        Assertions.assertThatNoException().isThrownBy(
                () -> new Game(names,result,height,ladder)
        );
    }
}

package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {
    @Test
    @DisplayName("Ladder 객체 생성 성공 테스트")
    void createLadderTest(){
        int playerNumber = 1;
        Assertions.assertThatNoException().isThrownBy(()->{Ladder ladderHeight =
                new Ladder(playerNumber,5);});
    }
}

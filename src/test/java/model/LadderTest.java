package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LadderTest {
    @Test
    @DisplayName("Ladder 객체 생성 성공 테스트")
    void createLadderTest(){
        Names name = new Names(Arrays.asList("ocean"));
        Assertions.assertThatNoException().isThrownBy(()->{Ladder ladderHeight =
                new Ladder(name,new LadderHeight(5));});
    }
}

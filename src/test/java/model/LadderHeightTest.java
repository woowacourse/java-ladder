package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderHeightTest {
    @Test
    @DisplayName("LadderHeight 객체 생성 성공 테스트")
    void createLadderHeightTest(){
        Assertions.assertThatNoException().isThrownBy(()->{LadderHeight ladderHeight = new LadderHeight(5);});
    }
}

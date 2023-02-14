package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class PlayerTest {

    @Test
    @DisplayName("Player 객체 생성 성공 테스트")
    void createPlayerTest(){
        Assertions.assertThatNoException().isThrownBy(()->{Player player = new Player("ocean");});
    }

}

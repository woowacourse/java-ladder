package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderResultTest {

    @Test
    @DisplayName("사다리 실행 결과 객체 생성 성공 테스트")
    void createLadderResultTest(){
        Assertions.assertThatNoException().isThrownBy(
                () -> new LadderResult("꽝,5000,꽝,3000")
        );
    }

}

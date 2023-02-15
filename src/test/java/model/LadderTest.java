package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    @DisplayName("Ladder 객체 생성 성공 테스트")
    void createLadderTest() {
        assertThatNoException().isThrownBy(()->{Ladder ladder = new Ladder(new LadderHeight(5));});
    }
}

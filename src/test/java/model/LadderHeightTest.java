package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class LadderHeightTest {
    @Test
    @DisplayName("LadderHeight 객체 생성 성공 테스트")
    void createLadderHeightTest(){
        Assertions.assertThatNoException().isThrownBy(()->{LadderHeight ladderHeight = new LadderHeight(5);});
    }

    @Test
    @DisplayName("LadderHeight가 1 미만일 경우 실패 테스트")
    void validateLadderHeightTest() {
        //When
        Throwable result = catchThrowable(()->{LadderHeight ladderHeight = new LadderHeight(0);});

        //Then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }
}

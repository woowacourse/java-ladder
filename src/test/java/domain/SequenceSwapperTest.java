package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SequenceSwapperTest {
    @Test
    @DisplayName("순서 변환 객체는 순서를 가지고 있다.")
    void makeValidSequenceTest() {
        SequenceSwapper swapper = SequenceSwapper.of(List.of(0, 1, 2, 3));
        assertThat(swapper.getSequence()).containsExactly(0, 1, 2, 3);
    }

    @Test
    @DisplayName("index를 입력하면 양 옆의 순서를 바꿔준다.")
    void swapSequenceTest(){
        SequenceSwapper swapper = SequenceSwapper.of(List.of(0, 1, 2, 3));
        swapper.swap(0);
        assertThat(swapper.getSequence()).containsExactly(1,0,2,3);
    }
}
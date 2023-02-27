package domain;

import domain.util.SequenceSwapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SequenceSwapperTest {
    @Test
    @DisplayName("순서 변환 객체는 순서를 가지고 있다.")
    void makeValidSequenceTest() {
        SequenceSwapper swapper = SequenceSwapper.initialize(4);
        assertThat(swapper.getSequence()).containsExactly(0, 1, 2, 3);
    }
    
    @Test
    @DisplayName("index를 입력하면 양 옆의 순서를 바꿔준다.")
    void swapSequenceTest() {
        SequenceSwapper swapper = SequenceSwapper.initialize(4);
        swapper.swap(0);
        assertThat(swapper.getSequence()).containsExactly(1, 0, 2, 3);
    }
    
    @Test
    @DisplayName("마지막 index를 넣으면 예외가 발생한다.")
    void makeInvalidSwapTest() {
        SequenceSwapper swapper = SequenceSwapper.initialize(4);
        assertThatThrownBy(() -> {
            swapper.swap(3);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
package domain;

import domain.Collection.Sequence;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class SequenceTest {
    @Test
    @DisplayName("순서 객체는 Integer 리스트를 받아서 생성한다.")
    public void generateSequenceTest() {
        List<Integer> numbers = List.of(0, 1, 2, 3, 4);
        assertThatNoException().isThrownBy(() -> {
            Sequence.of(numbers);
        });
    }
    
    @Test
    @DisplayName("순서 객체의 순서를 변환하면 새로운 순서 객체를 반환한다.")
    public void swapNewSequenceTest() {
        List<Integer> numbers = List.of(0, 1, 2, 3, 4);
        Sequence prevSequence = Sequence.of(numbers);
        Sequence newSequence = prevSequence.exchange(0);
        assertThat(newSequence).isNotEqualTo(prevSequence);
    }
}

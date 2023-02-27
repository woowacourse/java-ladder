package domain;

import domain.Collection.Sequence;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
}

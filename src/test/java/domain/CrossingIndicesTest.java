package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CrossingIndicesTest {

    @Test
    @DisplayName("인덱스를 추가할 때, 연속된 인덱스는 추가되지 않는다.")
    void ignoreContinuousIndicesTest() {
        // given
        CrossingIndices indices = new CrossingIndices();

        // when
        for (int i = 0; i < 10; i++) {
            indices.add(i);
        }

        // then
        List<Integer> expected = List.of(0, 2, 4, 6, 8);
        List<Integer> actual = indices.getCopyOfIndices();
        Assertions.assertThat(actual).containsExactlyElementsOf(expected);
    }
}

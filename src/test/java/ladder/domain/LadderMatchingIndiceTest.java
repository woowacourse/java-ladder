package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderMatchingIndiceTest {

    @Test
    void 생성자_0보다_작은_입력() {
        List<Integer> toIndice = Arrays.asList(-1);

        assertThrows(IllegalArgumentException.class, () -> LadderMatchingIndice.from(toIndice));
    }

    @Test
    void 생성자_범위를_초과하는_입력() {
        List<Integer> toIndice = Arrays.asList(0, 1, 2, 4);

        assertThrows(IllegalArgumentException.class, () -> LadderMatchingIndice.from(toIndice));
    }

    @Test
    void 생성자_중복된_입력() {
        List<Integer> toIndice = Arrays.asList(0, 1, 2, 2);

        assertThrows(IllegalArgumentException.class, () -> LadderMatchingIndice.from(toIndice));
    }

    @Test
    void to() {
        List<Integer> toIndice = Arrays.asList(2, 1, 0);
        LadderMatchingIndice machingIndice = LadderMatchingIndice.from(toIndice);

        for (int from = 0; from < toIndice.size(); from++) {
            assertThat(machingIndice.to(from)).isEqualTo(toIndice.get(from));
        }
    }
}
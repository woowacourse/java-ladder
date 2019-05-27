package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static ladder.domain.ResultIndex.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResultIndexTest {
    @Test
    void 사다리_탄_결과_리스트가_비었을_경우() {
        assertThrows(IllegalArgumentException.class, () -> validateEmpty(Arrays.asList()));
    }

    @Test
    void 사다리_탄_결과_중복된_인덱스가_있는_경우() {
        assertThrows(IllegalArgumentException.class, () -> validateDuplication(Arrays.asList(0, 1, 1)));
    }

    @Test
    void 사다리_탄_결과_연속되지않은_인덱스가_있는_경우() {
        assertThrows(IllegalArgumentException.class, () -> validateRange(Arrays.asList(0, 3, 2)));
    }
}

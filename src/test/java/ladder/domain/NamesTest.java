package ladder.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class NamesTest {

    @Test
    void names가_null_인_경우_예외() {
        assertThrows(IllegalArgumentException.class, () -> new Names(null));
    }

    @Test
    void names_길이가_1인_경우_예외() {
        assertThrows(IllegalArgumentException.class, () -> new Names("aaa"));
    }

    @Test
    void names_길이가_2이상이면_통과() {
        assertDoesNotThrow(() -> new Names("aaa,aa,a"));
    }
}

package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResultsTest {
    @Test
    void 결과명들_콤마시작_검사() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Results(",abc,abc", 2);
        });
    }

    @Test
    void 결과명들_콤마끝_검사() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Results("abc,abc,", 2);
        });
    }

    @Test
    void 결과명들_콤마중복_검사() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Results("abc,,abc", 2);
        });
    }

    @Test
    void 결과명들_콤마만입력_검사() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Results(",", 0);
        });
    }
}

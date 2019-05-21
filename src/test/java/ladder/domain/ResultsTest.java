package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResultsTest {
    @Test
    void 결과의_갯수가_입력받은_수와_같은_경우() {
        List<String> names = Arrays.asList("꽝", "당첨", "꽝");

        assertDoesNotThrow(() -> Results.checkNumberOfResult(names, 3));
    }

    @Test
    void 결과의_갯수가_입력받은_수와_다른_경우() {
        List<String> names = Arrays.asList("꽝", "당첨", "꽝");

        assertThrows(IllegalArgumentException.class, () -> Results.checkNumberOfResult(names, 4));
    }
}

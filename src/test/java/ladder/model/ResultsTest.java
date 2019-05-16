package ladder.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResultsTest {
    @Test
    void 플레이어수_결과수_일치_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
           new Results("aa,bb",3);
        });
    }
}

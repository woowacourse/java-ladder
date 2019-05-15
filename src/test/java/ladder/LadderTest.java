package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {

    @Test
    void 라인_수가_0_이하_일_때_테스트(){
        assertThrows(IllegalArgumentException.class, () -> new Ladder(1,0));

    }
}

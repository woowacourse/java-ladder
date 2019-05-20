package laddergame.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrizesTest {
    @Test
    void 상품의_숫자가_맞지않을때_테스트() {
        String test = "a,b,c";
        assertThrows(IllegalArgumentException.class, ()-> new Prizes(2,test));
    }
}

package laddergame.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayersTest {
    @Test
    void 이름중_공백이_있을때_테스트() {
        String test = "a,,b";
        assertThrows(IllegalArgumentException.class, ()-> new Players(test));
    }

    @Test
    void 이름이_NULL_일때_테스트() {
        String test = null;
        assertThrows(IllegalArgumentException.class, ()-> new Players(test));
    }

    @Test
    void 이름중_중복이_있을때_테스트() {
        String test = "a,a,b";
        assertThrows(IllegalArgumentException.class, ()-> new Players(test));
    }

    @Test
    void 이름중_빈칸이_있을때_테스트() {
        String test = "a,   ,b";
        assertThrows(Exception.class, ()-> new Players(test));
    }

    @Test
    void 이름의_길이가_적합하지_않을때_테스트() {
        String test = "a,b,125214234234";
        assertThrows(Exception.class, ()-> new Players(test));
    }
}

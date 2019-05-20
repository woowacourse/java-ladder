package laddergame.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RequestTest {
    @Test
    void 리퀘스트에_이름이_없을때_테스트() {
        Players players = new Players("pobi,crong,brown");
        String test = "jason";

        assertThrows(IllegalArgumentException.class, ()-> new Request(players, test));
    }
}

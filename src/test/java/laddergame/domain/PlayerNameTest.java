package laddergame.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerNameTest {

    @Test
    void 이름이_Null일때_예외테스트() {
        assertThrows(IllegalArgumentException.class, () ->
                new PlayerName(null));
    }

    @Test
    void 이름의_길이가_1보다_짧을때() {
        assertThrows(IllegalArgumentException.class, () ->
                new PlayerName(""));
    }

    @Test
    void 이름의_길이가_5보다_길때() {
        assertThrows(IllegalArgumentException.class, () ->
                new PlayerName("aadsfsdfsadfadf"));
    }
}

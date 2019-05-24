package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void 생성자_null() {
        assertThrows(IllegalArgumentException.class, () -> Player.from(null));
    }

    @Test
    void 생성자_빈문자열() {
        assertThrows(IllegalArgumentException.class, () -> Player.from(""));
    }

    @Test
    void 생성자_길이_MAX이상() {
        assertThrows(IllegalArgumentException.class, () -> Player.from(generateString(Player.MAX_NAME_LEN + 1)));
    }

    private String generateString(int len) {
        StringBuilder sb = new StringBuilder();

        char ch = 'a';
        for(int i = 0; i < len; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
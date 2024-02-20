package ladderGame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {

    @Test
    @DisplayName("문자열 리스트를 인자로 받아서 참여자들을 생성한다.")
    void createPlayers() {
        List<String> names = List.of("켬미", "초롱");
        assertThatCode(() -> new Players(names));
    }
}
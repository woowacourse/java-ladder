package laddergame.domain.ladder;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Map;
import laddergame.domain.ladder.destination.Item;
import laddergame.domain.players.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class GameResultTest {

    @Test
    @DisplayName("참여자 이름에 대한 결과가 없을 경우 예외를 던진다.")
    void should_ThrowException_When_No_Result() {
        GameResult gameResult = new GameResult(Map.of(new Name("test"), new Item("test")));

        assertThatThrownBy(() -> gameResult.findByPlayerName("wrong"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자 정보가 존재하지 않습니다.");
    }
}

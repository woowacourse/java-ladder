package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class PlayersTest {

    @DisplayName("참여자 간 이름이 중복되면 에외가 발생한다.")
    @Test
    void occurExceptionIfNameIsDuplicated() {
        assertThatThrownBy(() -> new Players(List.of("test1", "test2", "test2")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자의 이름은 중복될 수 없습니다.");
    }

    @DisplayName("결과를 조회할 참여자의 인덱스를 반환한다.")
    @Test
    void returnIndexOfResultName() {
        Players players = new Players(List.of(
                "pobi", "honux", "crong", "jk"
        ));
        String resultName = "crong";

        int index = players.findPositionOfPlayer(resultName);
        assertThat(index).isEqualTo(2);
    }
}

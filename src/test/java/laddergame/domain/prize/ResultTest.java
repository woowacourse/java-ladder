package laddergame.domain.prize;

import laddergame.domain.player.Names;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static laddergame.domain.prize.ResultFixture.coil;
import static laddergame.domain.prize.ResultFixture.ethan;
import static laddergame.domain.prize.ResultFixture.junPk;
import static laddergame.domain.prize.ResultFixture.result;
import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    private ResultFixture fixture;

    @BeforeEach
    void setUp() {
        fixture = new ResultFixture();
    }

    @Test
    @DisplayName("플레이어 이름들을 찾으면 Names로 반환된다.")
    void whenFindPlayerNames_thenReturnNames() {
        // when
        final Names playerNames = result.findPlayerNames();

        // then
        assertThat(playerNames.getNames())
                .containsExactly(ethan.getName(), coil.getName(), junPk.getName());
    }
}

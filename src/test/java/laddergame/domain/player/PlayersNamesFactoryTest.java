package laddergame.domain.player;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PlayersNamesFactoryTest {

    @Test
    public void 객제_생성_검사() {
        PlayersFactory playersFactory = new PlayersFactory("pobi,crong");
        assertThat(playersFactory).isEqualTo(new PlayersFactory("pobi,crong"));
    }

    @Test
    public void 공백이_입력되어있을때_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayersFactory(" ").create();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayersFactory("").create();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayersFactory(null).create();
        });
    }

    @Test
    public void 이름목록에_스페이스가_포함되어있을때_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayersFactory(" ,pobi,honux,crong,jk").create();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayersFactory("pobi,honux,crong,jk, ").create();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayersFactory("pobi,honux, ,crong,jk").create();
        });
    }

    @Test
    public void 이름목록에_공백이_포함되어있을때_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayersFactory(",pobi,honux,crong,jk").create();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayersFactory("pobi,honux,crong,jk,").create();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayersFactory("pobi,honux,,crong,jk,").create();
        });
    }

    @Test
    public void 이름에_중복이_있을_경우_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayersFactory(",pobi,pobi,crong,jk").create();
        });
    }
}

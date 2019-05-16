package laddergame.domain.player;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PlayerBuilderTest {

    @Test
    public void 객제_생성_검사() {
        PlayerBuilder playerBuilder = new PlayerBuilder("pobi,crong");
        assertThat(playerBuilder).isEqualTo(new PlayerBuilder("pobi,crong"));
    }

    @Test
    public void 공백이_입력되어있을때_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayerBuilder(" ").buildPlayers();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayerBuilder("").buildPlayers();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayerBuilder(null).buildPlayers();
        });
    }

    @Test
    public void 이름목록에_스페이스가_포함되어있을때_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayerBuilder(" ,pobi,honux,crong,jk").buildPlayers();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayerBuilder("pobi,honux,crong,jk, ").buildPlayers();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayerBuilder("pobi,honux, ,crong,jk").buildPlayers();
        });
    }

    @Test
    public void 이름목록에_공백이_포함되어있을때_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayerBuilder(",pobi,honux,crong,jk").buildPlayers();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayerBuilder("pobi,honux,crong,jk,").buildPlayers();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayerBuilder("pobi,honux,,crong,jk,").buildPlayers();
        });
    }

    @Test
    public void 이름에_중복이_있을_경우_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayerBuilder(",pobi,pobi,crong,jk").buildPlayers();
        });
    }
}

package laddergame.domain.player;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PlayersElementFactoryTest {

    @Test
    public void 객제_생성_검사() {
        PlayersBuilder playersBuilder = new PlayersBuilder("pobi,crong");
        assertThat(playersBuilder).isEqualTo(new PlayersBuilder("pobi,crong"));
    }

    @Test
    public void 공백이_입력되어있을때_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayersBuilder(" ").createElement();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayersBuilder("").createElement();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayersBuilder(null).createElement();
        });
    }

    @Test
    public void 이름목록에_스페이스가_포함되어있을때_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayersBuilder(" ,pobi,honux,crong,jk").createElement();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayersBuilder("pobi,honux,crong,jk, ").createElement();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayersBuilder("pobi,honux, ,crong,jk").createElement();
        });
    }

    @Test
    public void 이름목록에_공백이_포함되어있을때_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayersBuilder(",pobi,honux,crong,jk").createElement();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayersBuilder("pobi,honux,crong,jk,").createElement();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayersBuilder("pobi,honux,,crong,jk,").createElement();
        });
    }

    @Test
    public void 이름에_중복이_있을_경우_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayersBuilder(",pobi,pobi,crong,jk").createElement();
        });
    }
}

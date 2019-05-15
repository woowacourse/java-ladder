package laddergame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PlayerMakerTest {

    @Test
    public void 객제_생성_검사() {
        PlayerMaker playerMaker = new PlayerMaker("pobi,crong");
        assertThat(playerMaker).isEqualTo(new PlayerMaker("pobi,crong"));
    }

    @Test
    public void 공백이_입력되어있을때_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayerMaker(" ").makePlayers();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayerMaker("").makePlayers();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayerMaker(null).makePlayers();
        });
    }

    @Test
    public void 이름목록에_스페이스가_포함되어있을때_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayerMaker(" ,pobi,honux,crong,jk").makePlayers();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayerMaker("pobi,honux,crong,jk, ").makePlayers();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayerMaker("pobi,honux, ,crong,jk").makePlayers();
        });
    }

    @Test
    public void 이름목록에_공백이_포함되어있을때_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayerMaker(",pobi,honux,crong,jk").makePlayers();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayerMaker("pobi,honux,crong,jk,").makePlayers();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayerMaker("pobi,honux,,crong,jk,").makePlayers();
        });
    }
}

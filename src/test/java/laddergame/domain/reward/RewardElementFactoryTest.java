package laddergame.domain.reward;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RewardElementFactoryTest {

    @Test
    public void 객제_생성_검사() {
        RewardsBuilder playerMaker = new RewardsBuilder("pobi,crong");
        assertThat(playerMaker).isEqualTo(new RewardsBuilder("pobi,crong"));
    }

    @Test
    public void 공백이_입력되어있을때_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new RewardsBuilder(" ").createElement();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new RewardsBuilder("").createElement();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new RewardsBuilder(null).createElement();
        });
    }

    @Test
    public void 이름목록에_스페이스가_포함되어있을때_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new RewardsBuilder(" ,pobi,honux,crong,jk").createElement();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new RewardsBuilder("pobi,honux,crong,jk, ").createElement();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new RewardsBuilder("pobi,honux, ,crong,jk").createElement();
        });
    }

    @Test
    public void 이름목록에_공백이_포함되어있을때_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new RewardsBuilder(",pobi,honux,crong,jk").createElement();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new RewardsBuilder("pobi,honux,crong,jk,").createElement();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new RewardsBuilder("pobi,honux,,crong,jk,").createElement();
        });
    }
}
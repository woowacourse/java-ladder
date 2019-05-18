package laddergame.domain.reward;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RewardNamesFactoryTest {

    @Test
    public void 객제_생성_검사() {
        RewardsFactory playerMaker = new RewardsFactory("pobi,crong");
        assertThat(playerMaker).isEqualTo(new RewardsFactory("pobi,crong"));
    }

    @Test
    public void 공백이_입력되어있을때_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new RewardsFactory(" ").create();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new RewardsFactory("").create();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new RewardsFactory(null).create();
        });
    }

    @Test
    public void 이름목록에_스페이스가_포함되어있을때_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new RewardsFactory(" ,pobi,honux,crong,jk").create();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new RewardsFactory("pobi,honux,crong,jk, ").create();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new RewardsFactory("pobi,honux, ,crong,jk").create();
        });
    }

    @Test
    public void 이름목록에_공백이_포함되어있을때_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new RewardsFactory(",pobi,honux,crong,jk").create();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new RewardsFactory("pobi,honux,crong,jk,").create();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new RewardsFactory("pobi,honux,,crong,jk,").create();
        });
    }
}
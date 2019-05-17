package laddergame.domain.result;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class DestinationBuilderTest {

    @Test
    public void 객제_생성_검사() {
        DestinationsBuilder playerMaker = new DestinationsBuilder("pobi,crong");
        assertThat(playerMaker).isEqualTo(new DestinationsBuilder("pobi,crong"));
    }

    @Test
    public void 공백이_입력되어있을때_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new DestinationsBuilder(" ").buildDestinations();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new DestinationsBuilder("").buildDestinations();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new DestinationsBuilder(null).buildDestinations();
        });
    }

    @Test
    public void 이름목록에_스페이스가_포함되어있을때_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new DestinationsBuilder(" ,pobi,honux,crong,jk").buildDestinations();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new DestinationsBuilder("pobi,honux,crong,jk, ").buildDestinations();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new DestinationsBuilder("pobi,honux, ,crong,jk").buildDestinations();
        });
    }

    @Test
    public void 이름목록에_공백이_포함되어있을때_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new DestinationsBuilder(",pobi,honux,crong,jk").buildDestinations();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new DestinationsBuilder("pobi,honux,crong,jk,").buildDestinations();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new DestinationsBuilder("pobi,honux,,crong,jk,").buildDestinations();
        });
    }
}
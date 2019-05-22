package laddergame.domain.result;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ResultBuilderTest {

    @Test
    public void 공백이_입력되어있을때_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            ResultBuilder.buildResults(" ");
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            ResultBuilder.buildResults("");
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            ResultBuilder.buildResults(null);
        });
    }

    @Test
    public void 이름목록에_스페이스가_포함되어있을때_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            ResultBuilder.buildResults(" ,pobi,honux,crong,jk");
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            ResultBuilder.buildResults("pobi,honux,crong,jk, ");
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            ResultBuilder.buildResults("pobi,honux, ,crong,jk");
        });
    }

    @Test
    public void 이름목록에_공백이_포함되어있을때_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            ResultBuilder.buildResults(",pobi,honux,crong,jk");
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            ResultBuilder.buildResults("pobi,honux,crong,jk,");
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            ResultBuilder.buildResults("pobi,honux,,crong,jk,");
        });
    }
}
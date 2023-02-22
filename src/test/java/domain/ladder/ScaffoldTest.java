package domain.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Scaffold 는")
public class ScaffoldTest {

    @Test
    void 존재_혹은_존재하지않음_상태를_가진다() {
        assertDoesNotThrow(() -> Scaffold.EXIST);
        assertDoesNotThrow(() -> Scaffold.NONE);
    }

    @Test
    void isExist_는_EXIST_인_경우애만_true_이다() {
        // when & then
        Assertions.assertThat(Scaffold.EXIST.isExist()).isTrue();
        Assertions.assertThat(Scaffold.NONE.isExist()).isFalse();
    }
}

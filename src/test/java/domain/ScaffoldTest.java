package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Scaffold 는")
public class ScaffoldTest {

    @Test
    void 존재_혹은_존재하지않음_상태를_가진다() {
        assertDoesNotThrow(() -> Scaffold.EXIST);
        assertDoesNotThrow(() -> Scaffold.NONE);
    }

    @ParameterizedTest(name = "EXIST인지 아닌지 알 수 있다 입력값:{0} 결과:{1}")
    @CsvSource({"EXIST,true", "NONE,false"})
    void Exist_인지_알_수_있다(final Scaffold scaffold, final boolean result) {
        assertThat(scaffold.isExist()).isEqualTo(result);
    }
}

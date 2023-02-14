package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LineStatusTest {

    @ParameterizedTest(name = "boolean 값을 입력받아 LineStatus를 반환한다. 입력값:{0} 결과:{1}")
    @CsvSource({"true,GO", "false,STOP"})
    void boolean_값을_입력받아_LineStatus를_반환한다(final boolean status, final LineStatus result) {
        assertThat(LineStatus.from(status)).isEqualTo(result);
    }

}

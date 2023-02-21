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
    @CsvSource({"true,CONNECTED", "false,DISCONNECTED"})
    void boolean_값을_입력받아_LineStatus를_반환한다(final boolean status, final LineStatus result) {
        assertThat(LineStatus.from(status)).isEqualTo(result);
    }

    @ParameterizedTest(name = "연결 상태인지 확인한다. 입력값:{0} 결과:{1}")
    @CsvSource({"CONNECTED,true", "DISCONNECTED,false"})
    void 연결_상태인지_확인한다(final LineStatus status, final boolean result) {
        assertThat(status.isConnected()).isEqualTo(result);
    }

    @ParameterizedTest(name = "연결 상태가 아닌지 확인한다. 입력값:{0} 결과:{1}")
    @CsvSource({"CONNECTED,false", "DISCONNECTED,true"})
    void 연결_상태가_아닌지_확인한다(final LineStatus status, final boolean result) {
        assertThat(status.isDisconnected()).isEqualTo(result);
    }
}

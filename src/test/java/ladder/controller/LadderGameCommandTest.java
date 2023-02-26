package ladder.controller;

import static ladder.controller.LadderGameCommand.from;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LadderGameCommandTest {

    @ParameterizedTest(name = "all을 입력하면 MULTIPLE을 반환하고 나머지의 경우 SINGLE을 반환한다. 입력: {0}, 결과: {1}")
    @CsvSource({"all,MULTIPLE", "herb,SINGLE"})
    void all을_입력하면_MULTIPLE을_반환하고_나머지의_경우_SINGLE을_반환한다(final String input, final LadderGameCommand command) {
        assertThat(from(input)).isEqualTo(command);
    }

    @ParameterizedTest(name = "Command에 따라서 결과출력을 계속할지 결정한다. 커맨드: {0}, 결과: {1}")
    @CsvSource({"MULTIPLE,false", "SINGLE,true"})
    void Command에_따라서_결과출력을_계속할지_결정한다(final LadderGameCommand command, final boolean result) {
        assertThat(command.isContinued()).isEqualTo(result);
    }
}

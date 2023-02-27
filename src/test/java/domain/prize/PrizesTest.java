package domain.prize;

import domain.prize.Prizes;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.Parser;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

public class PrizesTest {

    @DisplayName("사다리 게임의 실행 결과는 참여하는 사람의 수 만큼 입력받지 않으면 예외를 발생시킨다.")
    @ParameterizedTest
    @CsvSource(value = {"꽝,5000,꽝:2", "꽝:2"}, delimiter = ':')
    void prizesValidateTest1(String input, int personCount) {
        List<String> prizes = Parser.parse(input, ",");
        Assertions.assertThatThrownBy(() -> Prizes.of(prizes, personCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 게임의 실행 결과는 사람 수와 동일하게 입력해야합니다.");
    }

    @DisplayName("각 사다리 게임의 실행 결과가 1글자에서 5글자 사이로 입력되고, 사다리 게임 참가자 수만큼 입력이 된 경우 Prize가 생성된다.")
    @ParameterizedTest
    @CsvSource(value = {"꽝,5000,꽝,도:4", "꽝,5000:2"}, delimiter = ':')
    void prizesValidateTest3(String input, int personCount) {
        List<String> prizes = Parser.parse(input, ",");
        assertThatCode(() -> Prizes.of(prizes, personCount))
                .doesNotThrowAnyException();
    }
}

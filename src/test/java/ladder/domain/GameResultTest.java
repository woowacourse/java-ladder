package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GameResultTest {
    @DisplayName("동일한 이름인 경우 true를, 다른 이름인 경우 false를 반환한다.")
    @CsvSource(value = {"liv:true", "kelly:false"}, delimiter = ':')
    @ParameterizedTest
    void checkSameName(String name, boolean expected) {
        GameResult gameResult = new GameResult(new UserName("liv"), new Destination("3000"));

        assertThat(gameResult.isSameName(name)).isEqualTo(expected);
    }
}

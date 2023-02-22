package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class PlayerTest {
    @ParameterizedTest(name = "Player 객체 name ={0} 생성 성공 테스트")
    @CsvSource(value = {"pobi:pobi", "honux:honux", "crong:crong"}, delimiter = ':')
    void createPlayerTest(String input, String result) {
        Assertions.assertThatNoException().isThrownBy(() -> new Player(new Names(input), result));
    }

    @ParameterizedTest(name = "Player 객체 name ={0} 생성 실패 테스트")
    @CsvSource(value = {"pobi:po", "honux:h", "crong:crongcrong"}, delimiter = ':')
    void createPlayerFailTest(String input, String result) {
        Assertions.assertThatThrownBy(() -> new Player(new Names(input), result)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "Player 객체 name ={0} 생성 실패 테스트")
    @NullAndEmptySource
    void createPlayerNullEmptyFailTest(String result) {
        Assertions.assertThatThrownBy(() -> new Player(new Names("ocean"), result)).isInstanceOf(Exception.class);
    }
}

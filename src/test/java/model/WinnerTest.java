package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class WinnerTest {
    @ParameterizedTest(name = "Winner 객체 name ={0} 생성 성공 테스트")
    @CsvSource(value = {"pobi:pobi", "honux:honux", "crong:crong"}, delimiter = ':')
    void createWinnerTest(String input, String result) {
        Assertions.assertThatNoException().isThrownBy(() -> new Winner(new Names(input), result));
    }

    @ParameterizedTest(name = "Winner 객체 name ={0} 생성 실패 테스트")
    @CsvSource(value = {"pobi:po", "honux:h", "crong:crongcrong"}, delimiter = ':')
    void createWinnerFailTest(String input, String result) {
        Assertions.assertThatThrownBy(() -> new Winner(new Names(input), result)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "Winner 객체 name ={0} 생성 실패 테스트")
    @NullAndEmptySource
    void createWinnerNullEmptyFailTest(String result) {
        Assertions.assertThatThrownBy(() -> new Winner(new Names("ocean"), result)).isInstanceOf(Exception.class);
    }

    @Test
    @DisplayName("Winner 결과 대상자 all 입력 성공 테스트")
    void checkAllEndWinnerTest(){
        Winner winner = new Winner(new Names("pobi"), "all");
        Assertions.assertThat(winner.isAllEndWinner()).isTrue();
    }
}

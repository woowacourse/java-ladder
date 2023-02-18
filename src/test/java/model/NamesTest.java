package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class NamesTest {

    @Test
    @DisplayName("Names 객체 생성 성공 테스트")
    void createNamesTest() {
        Names names = new Names("pobi,crong,honux");
        assertThat(names.getNames().size()).isEqualTo(3);
    }

    @ParameterizedTest(name = "Names 객체 생성 실패 테스트 name={0}")
    @ValueSource(strings = {" ","   ","12345,45678","aaaaaa,bbbbbb"})
    void createNamesTest(String input) {
        Assertions.assertThatThrownBy(()->{
            new Names(input);
        });
    }

}

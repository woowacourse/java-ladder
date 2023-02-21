package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NamesTest {

    @DisplayName("참가자의 숫자가 0명이면 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenSizeEqualZero() {
        List<String> names = List.of();
        assertThatThrownBy(() -> new Names(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자는 2명 이상이어야 합니다.");
    }

    @DisplayName("참가자의 숫자가 1명이면 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenSizeEqualOne() {
        List<String> names = List.of("one");
        assertThatThrownBy(() -> new Names(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자는 2명 이상이어야 합니다.");
    }

    @DisplayName("참가자의 숫자가 2명이면 예외를 발생시키지 않는다.")
    @Test
    void doesNotThrowExceptionWhenSizeIsMoreThanTwo() {
        List<String> names = List.of("one", "two");
        assertThatCode(() -> new Names(names))
                .doesNotThrowAnyException();
    }

    @DisplayName("참가자의 이름이 하나라도 잘못된 경우 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenNamesHasInvalidName() {
        List<String> names = List.of("o", "odo27", "konghana");
        assertThatThrownBy(() -> new Names(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1글자에서 5글자 사이이어야 합니다.");
    }

    @DisplayName("참가자의 이름이 모두 올바른 경우 예외를 발생시키지 않는다.")
    @Test
    void doesNotThrowExceptionWhenNamesOnlyHasValidName() {
        List<String> names = List.of("ko ng", "   odo    ", "od  o");
        assertThatCode(() -> new Names(names))
                .doesNotThrowAnyException();
    }

    @DisplayName("이름으로 번호를 찾을 수 있다.")
    @ParameterizedTest
    @CsvSource({"pobi,0", "honux,1", "crong,2", "jk,3"})
    void shouldReturnIndexOfName(String name, int expected) {
        List<String> names = List.of("pobi", "honux", "crong", "jk");
        assertThat(new Names(names).findByName(name)).isEqualTo(expected);
    }

    @DisplayName("이름으로 번호를 찾을 수 없다면 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenCanNotFindByName() {
        List<String> names = List.of("pobi", "honux", "crong", "jk");
        assertThatThrownBy(() -> new Names(names).findByName("odo27"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

package laddergame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NamesTest {

    @Test
    @DisplayName("List<String>이 입력되면 Names 객체를 생성한다.")
    void givenStringList_thenCreateNames() {
        //given
        final List<String> names = List.of("에단", "준팍");

        //when
        final Names result = new Names(names);

        //then
        Assertions.assertThat(result.getNames())
                .isEqualTo(names);
    }

    @Test
    @DisplayName("List<String>의 길이가 2미만이면 예외를 발생한다.")
    void givenTwoUnderStringListSize_thenFail() {
        //given
        final List<String> wrongSizeList = List.of("에단");

        //then
        assertThatThrownBy((() -> new Names(wrongSizeList)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("가장 긴 이름의 길이를 반환한다.")
    void giveNames_thenReturnMaxNameLength() {
        //given
        final List<String> names = List.of("에단", "준팍", "블랙캣");
        final Names names1 = new Names(names);

        //when
        final int maxNameLength = names1.findMaxNameLength();

        //then
        assertThat(maxNameLength).isEqualTo(3);
    }

}

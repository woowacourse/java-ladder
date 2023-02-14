package laddergame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.List;

public class NamesTest {

    @Test
    @DisplayName("문자열 리스트로 Names 객체를 생성한다.")
    void givenStringList_thenCreateNames() {
        //given
        final List<String> names = List.of("에단", "준팍");

        //when
        final Names result = new Names(names);

        //then
        Assertions.assertThat(result)
                .extracting("names")
                .isEqualTo(List.of(new Name("에단"), new Name("준팍")));
    }
}

package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NamesTest {
    private static Stream<Arguments> provideNamesInputValues() {
        return Stream.of(
                Arguments.of("hiiro", List.of("hiiro")),
                Arguments.of("pobi, neo, conan, ocean, hiiro",
                        List.of("pobi", "neo", "conan", "ocean", "hiiro"))
        );
    }

    @Test
    @DisplayName("Names 객체 생성 성공 테스트")
    void createNamesTest() {
        assertThatNoException().isThrownBy(() -> new Names("pobi, neo, conan"));
    }

    @ParameterizedTest
    @MethodSource("provideNamesInputValues")
    @DisplayName("참여자 이름은 쉼표를 기준으로 입력받는 기능 테스트")
    void splitNamesByCommas(String inputValue, List<String> expectedResult) {
        //given
        Names names = new Names(inputValue);

        //then
        assertThat(names.getValues()).isEqualTo(expectedResult);
    }
}

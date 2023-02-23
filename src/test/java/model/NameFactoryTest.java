package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NameFactoryTest {
    private static final String DUPLICATED_NAME_ERROR = "[ERROR] 참가자 이름은 중복될 수 없습니다.";

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
        assertThatNoException().isThrownBy(() -> NameFactory.create("pobi, neo, conan"));
    }

    @ParameterizedTest
    @MethodSource("provideNamesInputValues")
    @DisplayName("참여자 이름은 쉼표를 기준으로 입력받는 기능 테스트")
    void splitNamesByCommasTest(String inputValue, List<String> expectedResult) {
        //given
        List<Name> createdNames= NameFactory.create(inputValue);

        //when
        List<String> thenResult = createdNames.stream()
                .map(Name::getValue)
                .collect(Collectors.toList());

        //then
        assertThat(thenResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("참여자 이름 중복 여부 검사 기능 테스트")
    void validateDuplicatedNamesTest() {
        assertThatThrownBy(() -> NameFactory.create("pobi, pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATED_NAME_ERROR);
    }
}

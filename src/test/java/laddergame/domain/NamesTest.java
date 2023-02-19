package laddergame.domain;

import laddergame.fixture.NameFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("이름 목록")
class NamesTest {
    @DisplayName("생성된다.")
    @ParameterizedTest(name = "names = {0}")
    @MethodSource("namesDummy")
    void create(final List<String> names) {
        assertDoesNotThrow(() -> new Names(names));
    }

    @DisplayName("Name 리스트가 null일 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenNamesIsNull() {
        final List<String> names = null;

        assertThatThrownBy(() -> new Names(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Name 리스트가 2명 미만일 경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("namesWrongParameterDummy")
    void throwExceptionWhenNamesHasSizeLessThan2(final List<String> names) {
        assertThatThrownBy(() -> new Names(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Name 리스트의 크기를 가져온다.")
    @ParameterizedTest
    @MethodSource("namesDummy")
    void getSize(final List<String> inputNames) {
        final Names names = new Names(inputNames);
        final int inputNamesSize = inputNames.size();
        final int createdNamesSize = names.getSize();

        assertThat(createdNamesSize).isEqualTo(inputNamesSize);
    }

    @DisplayName("Name 리스트를 가져온다.")
    @ParameterizedTest
    @MethodSource("namesDummy")
    void getNames(final List<String> inputNames) {
        final Names names = new Names(inputNames);
        final List<String> findNames = names.getNames()
                .stream()
                .map(Name::getValue)
                .collect(Collectors.toList());

        assertThat(findNames).containsExactlyElementsOf(inputNames);
    }

    static Stream<Arguments> namesWrongParameterDummy() {
        return Stream.of(
                Arguments.arguments(List.of(NameFixture.createNameRosie().getValue())),
                Arguments.arguments(List.of(NameFixture.createNameHyena().getValue())),
                Arguments.arguments(List.of(NameFixture.createNameJayon().getValue()))
        );
    }

    static Stream<Arguments> namesDummy() {
        return Stream.of(
                Arguments.arguments(List.of(NameFixture.createNameRosie().getValue(), NameFixture.createNameHyena().getValue())),
                Arguments.arguments(List.of(NameFixture.createNameRosie().getValue(), NameFixture.createNameJayon().getValue())),
                Arguments.arguments(List.of(NameFixture.createNameHyena().getValue(), NameFixture.createNameJayon().getValue())),
                Arguments.arguments(List.of(NameFixture.createNameRosie().getValue(), NameFixture.createNameHyena().getValue(), NameFixture.createNameJayon().getValue()))
        );
    }
}
package laddergame.domain;

import laddergame.fixture.NameFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("이름 목록")
class NamesTest {
    @DisplayName("생성된다.")
    @ParameterizedTest
    @MethodSource("namesDummy")
    void create(final List<Name> names) {
        assertDoesNotThrow(() -> new Names(names));
    }

    @DisplayName("Name 리스트가 null일 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenNamesIsNull() {
        final List<Name> names = null;

        assertThatThrownBy(() -> new Names(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Name 리스트가 2명 미만일 경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("namesWrongParameterDummy")
    void throwExceptionWhenNamesHasSizeLessThan2(final List<Name> names) {
        assertThatThrownBy(() -> new Names(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Name 리스트의 크기를 가져온다.")
    @ParameterizedTest
    @MethodSource("namesDummy")
    void getSize(final List<Name> inputNames) {
        final Names names = new Names(inputNames);
        final int inputNamesSize = inputNames.size();
        final int createdNamesSize = names.getSize();

        assertThat(createdNamesSize).isEqualTo(inputNamesSize);
    }

    @DisplayName("Name 리스트를 가져온다.")
    @ParameterizedTest
    @MethodSource("namesDummy")
    void getNames(final List<Name> inputNames) {
        final Names names = new Names(inputNames);
        final List<Name> findNames = names.getNames();

        assertThat(findNames).containsExactlyElementsOf(inputNames);
    }

    static Stream<Arguments> namesWrongParameterDummy() {
        return Stream.of(
                Arguments.arguments(List.of(NameFixture.createNameRosie())),
                Arguments.arguments(List.of(NameFixture.createNameHyena())),
                Arguments.arguments(List.of(NameFixture.createNameJayon()))
        );
    }

    static Stream<Arguments> namesDummy() {
        return Stream.of(
                Arguments.arguments(List.of(NameFixture.createNameRosie(), NameFixture.createNameHyena())),
                Arguments.arguments(List.of(NameFixture.createNameRosie(), NameFixture.createNameJayon())),
                Arguments.arguments(List.of(NameFixture.createNameHyena(), NameFixture.createNameJayon())),
                Arguments.arguments(List.of(NameFixture.createNameRosie(), NameFixture.createNameHyena(), NameFixture.createNameJayon()))
        );
    }
}
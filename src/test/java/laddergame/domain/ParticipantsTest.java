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
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("참여자")
class ParticipantsTest {
    @DisplayName("생성된다.")
    @ParameterizedTest(name = "names = {0}")
    @MethodSource("namesDummy")
    void create(final List<Name> names) {
        assertDoesNotThrow(() -> new Participants(names));
    }

    @DisplayName("이름 목록이 비어있을 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenNamesIsEmpty() {
        final List<Name> names = List.of();

        assertThatThrownBy(() -> new Participants(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름 목록이 null일 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenNamesIsNull() {
        final List<Name> names = null;

        assertThatThrownBy(() -> new Participants(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름 목록이 2명 미만일 경우 예외가 발생한다.")
    @ParameterizedTest(name = "names = {0}")
    @MethodSource("oneNameDummy")
    void throwExceptionWhenNamesHasSizeLessThanTwo(final List<Name> names) {
        assertThatThrownBy(() -> new Participants(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름 목록의 크기를 가져온다.")
    @ParameterizedTest(name = "names = {0}")
    @MethodSource("namesDummy")
    void getSize(final List<Name> names) {
        final Participants participants = new Participants(names);
        final int totalSize = participants.getSize();

        assertThat(totalSize).isEqualTo(names.size());
    }

    @DisplayName("이름 목록을 가져온다.")
    @ParameterizedTest(name = "names = {0}, values = {1}")
    @MethodSource("namesWithValueDummy")
    void getNames(final List<Name> names, final List<String> nameValues) {
        final Participants participants = new Participants(names);
        assertThat(participants.getNames()).containsExactlyElementsOf(nameValues);
    }

    static Stream<Arguments> namesDummy() {
        return Stream.of(
                Arguments.arguments(List.of(NameFixture.getNameRosie(), NameFixture.getNameHyena())),
                Arguments.arguments(List.of(NameFixture.getNameRosie(), NameFixture.getNameJayon())),
                Arguments.arguments(List.of(NameFixture.getNameHyena(), NameFixture.getNameJayon())),
                Arguments.arguments(List.of(NameFixture.getNameJayon(), NameFixture.getNameHyena(), NameFixture.getNameRosie()))
        );
    }

    static Stream<Arguments> oneNameDummy() {
        return Stream.of(
                Arguments.arguments(List.of(NameFixture.getNameRosie())),
                Arguments.arguments(List.of(NameFixture.getNameHyena())),
                Arguments.arguments(List.of(NameFixture.getNameJayon()))
        );
    }

    static Stream<Arguments> namesWithValueDummy() {
        return Stream.of(
                Arguments.arguments(
                        List.of(NameFixture.getNameRosie(), NameFixture.getNameHyena()),
                        List.of(NameFixture.getNameRosie().getValue(), NameFixture.getNameHyena().getValue())),
                Arguments.arguments(
                        List.of(NameFixture.getNameRosie(), NameFixture.getNameJayon()),
                        List.of(NameFixture.getNameRosie().getValue(), NameFixture.getNameJayon().getValue())),
                Arguments.arguments(
                        List.of(NameFixture.getNameHyena(), NameFixture.getNameJayon()),
                        List.of(NameFixture.getNameHyena().getValue(), NameFixture.getNameJayon().getValue())),
                Arguments.arguments(
                        List.of(NameFixture.getNameRosie(), NameFixture.getNameHyena(), NameFixture.getNameJayon()),
                        List.of(NameFixture.getNameRosie().getValue(), NameFixture.getNameHyena().getValue(), NameFixture.getNameJayon().getValue()))
        );
    }
}
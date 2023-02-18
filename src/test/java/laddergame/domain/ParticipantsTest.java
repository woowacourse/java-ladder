package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static laddergame.fixture.NameFixture.*;
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
                Arguments.arguments(List.of(NAME_ROSIE, NAME_HYENA)),
                Arguments.arguments(List.of(NAME_ROSIE, NAME_JAYON)),
                Arguments.arguments(List.of(NAME_HYENA, NAME_JAYON)),
                Arguments.arguments(List.of(NAME_ROSIE, NAME_HYENA, NAME_JAYON))
        );
    }

    static Stream<Arguments> oneNameDummy() {
        return Stream.of(
                Arguments.arguments(List.of(NAME_ROSIE)),
                Arguments.arguments(List.of(NAME_HYENA)),
                Arguments.arguments(List.of(NAME_JAYON))
        );
    }

    static Stream<Arguments> namesWithValueDummy() {
        return Stream.of(
                Arguments.arguments(
                        List.of(NAME_ROSIE, NAME_HYENA),
                        List.of(NAME_ROSIE.getValue(), NAME_HYENA.getValue())),
                Arguments.arguments(
                        List.of(NAME_ROSIE, NAME_JAYON),
                        List.of(NAME_ROSIE.getValue(), NAME_JAYON.getValue())),
                Arguments.arguments(
                        List.of(NAME_HYENA, NAME_JAYON),
                        List.of(NAME_HYENA.getValue(), NAME_JAYON.getValue())),
                Arguments.arguments(
                        List.of(NAME_ROSIE, NAME_HYENA, NAME_JAYON),
                        List.of(NAME_ROSIE.getValue(), NAME_HYENA.getValue(), NAME_JAYON.getValue()))
        );
    }
}
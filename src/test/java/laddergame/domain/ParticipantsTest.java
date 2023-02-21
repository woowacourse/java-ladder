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

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("참여자")
class ParticipantsTest {
    @DisplayName("생성된다.")
    @ParameterizedTest(name = "names = {0}")
    @MethodSource("namesDummy")
    void create(final List<String> names) {
        assertDoesNotThrow(() -> new Participants(names));
    }

    @DisplayName("이름 목록이 null일 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenNamesIsNull() {
        final List<String> names = null;

        assertThatThrownBy(() -> new Participants(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름 목록의 크기를 가져온다.")
    @ParameterizedTest(name = "names = {0}")
    @MethodSource("namesDummy")
    void getSize(final List<String> names) {
        final Participants participants = new Participants(names);
        final int expectedSize = names.size();
        final int totalSize = participants.getSize();

        assertThat(totalSize).isEqualTo(expectedSize);
    }

    @DisplayName("이름들을 가져온다.")
    @ParameterizedTest(name = "names = {0}, values = {1}")
    @MethodSource("namesDummy")
    void getNames(final List<String> names) {
        final Participants participants = new Participants(names);
        final Names findNames = participants.getNames();
        final List<String> findNameValues = findNames.getNames().stream().map(Name::getValue).collect(Collectors.toList());
        assertThat(findNameValues).containsExactlyElementsOf(names);
    }

    @DisplayName("이름 목록을 가져온다.")
    @ParameterizedTest(name = "names = {0}, values = {1}")
    @MethodSource("namesDummy")
    void getNameValues(final List<String> names) {
        final Participants participants = new Participants(names);
        final List<String> nameValues = participants.getNameValues();
        assertThat(nameValues).containsExactlyElementsOf(names);
    }

    @DisplayName("참여자 위치를 이름을 통해서 가져온다.")
    @Test
    void findPositionByName() {
        final Participants participants = new Participants(
                List.of(NameFixture.createNameHyena().getValue(), NameFixture.createNameJayon().getValue()));
        final Position findPosition = participants.findPositionByName(NameFixture.createNameHyena().getValue());

        assertThat(findPosition.getValue()).isZero();
    }

    @DisplayName("위치를 통해서 이름을 가져온다.")
    @Test
    void findNameByPosition() {
        final String hyena = NameFixture.createNameHyena().getValue();
        final String jayon = NameFixture.createNameJayon().getValue();
        final Participants participants = new Participants(List.of(hyena, jayon));
        final Position position = new Position(0);
        final Name findName = participants.findNameByPosition(position);

        assertThat(findName.getValue()).isEqualTo(hyena);
    }

    static Stream<Arguments> namesDummy() {
        return Stream.of(
                Arguments.arguments(List.of(NameFixture.createNameRosie().getValue(), NameFixture.createNameHyena().getValue())),
                Arguments.arguments(List.of(NameFixture.createNameRosie().getValue(), NameFixture.createNameJayon().getValue())),
                Arguments.arguments(List.of(NameFixture.createNameHyena().getValue(), NameFixture.createNameJayon().getValue())),
                Arguments.arguments(List.of(NameFixture.createNameRosie().getValue(), NameFixture.createNameHyena().getValue(), NameFixture.createNameHyena().getValue()))
        );
    }
}
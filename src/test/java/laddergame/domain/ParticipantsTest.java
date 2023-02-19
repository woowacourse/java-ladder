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

    @DisplayName("이름 목록을 가져온다.")
    @ParameterizedTest(name = "names = {0}, values = {1}")
    @MethodSource("namesDummy")
    void getNames(final List<String> names) {
        final Participants participants = new Participants(names);
        assertThat(participants.getNames()).containsExactlyElementsOf(names);
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
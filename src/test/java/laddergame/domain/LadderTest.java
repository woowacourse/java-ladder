package laddergame.domain;

import laddergame.fixture.HeightFixture;
import laddergame.fixture.NameFixture;
import laddergame.fixture.ParticipantsFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static laddergame.fixture.BooleanGeneratorFixture.TEST_BOOLEAN_GENERATOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("사다리")
class LadderTest {
    @DisplayName("참여자가 null이면 예외가 발생한다.")
    @Test
    void throwExceptionWhenParticipantIsNull() {
        final Participants participants = null;

        assertThatThrownBy(() -> new Ladder(participants, HeightFixture.getHeightValue1()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("높이가 null이면 예외가 발생한다.")
    @Test
    void throwExceptionWhenHeightIsNull() {
        final Participants participants
                = new Participants(List.of(NameFixture.getNameRosie(), NameFixture.getNameHyena()));
        final Height height = null;

        assertThatThrownBy(() -> new Ladder(participants, height))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성한다.")
    @ParameterizedTest
    @MethodSource("ladderParameterDummy")
    void create(final Participants participants, final Height height) {
        assertDoesNotThrow(() -> new Ladder(participants, height));
    }

    @DisplayName("만들어진 라인 목록은 비어있지 않아야 한다.")
    @ParameterizedTest
    @MethodSource("ladderParameterDummy")
    void createdLineSizeIsNotEmpty(final Participants participants, final Height height) {
        final Ladder ladder = new Ladder(participants, height);
        final List<Line> createdLines = ladder.createLines(TEST_BOOLEAN_GENERATOR);

        assertThat(createdLines).isNotEmpty();
    }

    @DisplayName("생성된 라인의 개수는 높이와 같아야 한다.")
    @ParameterizedTest
    @MethodSource("ladderParameterDummy")
    void createLineSizeIsEqualToHeight(final Participants participants, final Height height) {
        final Ladder ladder = new Ladder(participants, height);
        final List<Line> createdLines = ladder.createLines(TEST_BOOLEAN_GENERATOR);

        assertThat(createdLines).hasSize(height.getValue());
    }

    static Stream<Arguments> ladderParameterDummy() {
        return Stream.of(
                Arguments.arguments(ParticipantsFixture.getParticipantsSize2(), HeightFixture.getHeightValue1()),
                Arguments.arguments(ParticipantsFixture.getParticipantsSize2(), HeightFixture.getHeightValue2()),
                Arguments.arguments(ParticipantsFixture.getParticipantsSize2(), HeightFixture.getHeightValue3()),
                Arguments.arguments(ParticipantsFixture.getParticipantsSize2(), HeightFixture.getHeightValue4()),
                Arguments.arguments(ParticipantsFixture.getParticipantsSize3(), HeightFixture.getHeightValue1()),
                Arguments.arguments(ParticipantsFixture.getParticipantsSize3(), HeightFixture.getHeightValue2()),
                Arguments.arguments(ParticipantsFixture.getParticipantsSize3(), HeightFixture.getHeightValue3()),
                Arguments.arguments(ParticipantsFixture.getParticipantsSize3(), HeightFixture.getHeightValue4())
        );
    }
}
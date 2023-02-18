package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static laddergame.TestDummy.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("사다리")
class LadderTest {

    @DisplayName("참여자가 null이면 예외가 발생한다.")
    @Test
    void throwExceptionWhenParticipantIsNull() {
        final Participants participants = null;
        final Height height = new Height(1);

        assertThatThrownBy(() -> new Ladder(participants, height, TEST_BOOLEAN_GENERATOR))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("높이가 null이면 예외가 발생한다.")
    @Test
    void throwExceptionWhenHeightIsNull() {
        final Participants participants = new Participants(List.of(NAME_HYENA));
        final Height height = null;

        assertThatThrownBy(() -> new Ladder(participants, height, TEST_BOOLEAN_GENERATOR))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성한다.")
    @Test
    void create() {
        final Participants participants = new Participants(List.of(NAME_HYENA, NAME_ROSIE));
        final Height height = new Height(2);

        assertDoesNotThrow(() -> new Ladder(participants, height, TEST_BOOLEAN_GENERATOR));
    }

    @DisplayName("라인 사이즈가 비면 예외가 발생한다.")
    @Test
    void createdLineSizeIsNotEmpty() {
        final Ladder ladder = new Ladder(PARTICIPANTS_SIZE_2, HEIGHT_VALUE_1, TEST_BOOLEAN_GENERATOR);

        assertThat(ladder.getLines()).isNotEmpty();
    }

    @DisplayName("생성된 라인의 개수는 높이와 같아야 한다.")
    @Test
    void createLineSizeIsEqualToHeight() {
        final Ladder ladder = new Ladder(PARTICIPANTS_SIZE_2, HEIGHT_VALUE_1, TEST_BOOLEAN_GENERATOR);

        assertThat(ladder.getLines()).hasSize(HEIGHT_VALUE_1.getValue());
    }

    @DisplayName("BooleanGenerator가 null이면 예외가 발생한다.")
    @Test
    void throwExceptionWhenBooleanGeneratorIsNull() {
        final BooleanGenerator generator = null;
        assertThatThrownBy(() -> new Ladder(PARTICIPANTS_SIZE_2, HEIGHT_VALUE_1, generator));
    }
    @DisplayName("라인 사이즈는 세로 길이와 같다.")
    @Test
    void returnsLinesSizeIsHeight() {
        final List<Line> lines = new Ladder(PARTICIPANTS_SIZE_2, new Height(5), TEST_BOOLEAN_GENERATOR).getLines();
        assertThat(lines).hasSize(5);
    }
}
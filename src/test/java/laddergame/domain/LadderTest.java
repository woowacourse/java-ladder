package laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static laddergame.TestDummy.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LadderTest {

    @Test
    void throwExceptionWhenParticipantIsNull() {
        final Participants participants = null;
        final Height height = new Height(1);

        assertThatThrownBy(() -> new Ladder(participants, height))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void throwExceptionWhenHeightIsNull() {
        final Participants participants = new Participants(List.of(NAME_HYENA));
        final Height height = null;

        assertThatThrownBy(() -> new Ladder(participants, height))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void create() {
        final Participants participants = new Participants(List.of(NAME_HYENA, NAME_ROSIE));
        final Height height = new Height(2);

        assertDoesNotThrow(() -> new Ladder(participants, height));
    }

    @Test
    void createdLineSizeIsNotEmpty() {
        final Ladder ladder = new Ladder(PARTICIPANTS_SIZE_2, HEIGHT_VALUE_1);
        final List<Line> createdLines = ladder.createLines(TEST_BOOLEAN_GENERATOR);

        assertThat(createdLines).isNotEmpty();
    }

    @Test
    void createLineSizeIsEqualToHeight() {
        final Ladder ladder = new Ladder(PARTICIPANTS_SIZE_2, HEIGHT_VALUE_1);
        final List<Line> createdLines = ladder.createLines(TEST_BOOLEAN_GENERATOR);

        assertThat(createdLines).hasSize(HEIGHT_VALUE_1.getValue());
    }
}
package utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
class LadderStatusTest {

    @Test
    void canPlay_메소드는_RadderStatus가_APPLICATION_EXIT라면_false를_반환한다() {
        assertThat(LadderStatus.APPLICATION_EXIT.canPlay()).isFalse();
    }

    @ParameterizedTest
    @EnumSource(names = {"INPUT_PARTICIPANT_NAMES", "GENERATE_LADDER", "PRINT_LADDER"})
    void canPlay_메소드는_RadderStatus가_APPLICATION_EXIT가_아니라면_true를_반환한다(LadderStatus ladderStatus) {
        assertThat(ladderStatus.canPlay()).isTrue();
    }
}
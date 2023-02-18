package domain;

import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Ladder 는")
public class LadderTest {

    ScaffoldGenerator scaffoldGenerator = new RandomScaffoldGenerator();

    @Test
    void Height_과_Width_와_ScaffoldGenerator_를_받아_생성된다() {
        // given
        final Width width = new Width(5);
        final Height height = new Height(5);

        assertDoesNotThrow(() -> new Ladder(width, height, scaffoldGenerator));
    }

    @Test
    void 인자로_받은_Height_을_높이로_가진다() {
        // given
        final Width width = new Width(5);
        final Height height = new Height(5);
        final int heightValue = 5;

        // when
        final Ladder ladder = new Ladder(width, height, scaffoldGenerator);

        // then
        assertThat(ladder.getHeight()).isEqualTo(heightValue);
    }

    @Test
    void 인자로_받은_Width_을_높이로_가진다() {
        // given
        final Width width = new Width(5);
        final Height height = new Height(5);
        final int widthValue = 5;

        // when
        final Ladder ladder = new Ladder(width, height, scaffoldGenerator);

        // then
        assertThat(ladder.getWidth()).isEqualTo(widthValue);
    }
}

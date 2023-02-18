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
import util.TestScaffoldGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Line 은")
public class LineTest {


    @Test
    void Width_와_ScaffoldGenerator_를_받아_생성된다() {
        // given
        final ScaffoldGenerator scaffoldGenerator = new RandomScaffoldGenerator();
        final Width width = new Width(4);

        //then
        assertDoesNotThrow(() -> new Line(width, scaffoldGenerator));
    }

    @Test
    void 입력받은_Width_만큼의_크기를_가진다() {
        //given
        final ScaffoldGenerator scaffoldGenerator = new RandomScaffoldGenerator();
        final Width width = new Width(4);

        // when
        Line line = new Line(width, scaffoldGenerator);

        // then
        assertThat(line.size()).isEqualTo(width.getValue());
    }

    @Test
    void 너비를_받아_라인상태값을_생성한다() {
        // given
        final TestScaffoldGenerator testScaffoldGenerator = new TestScaffoldGenerator(List.of(true, false, true, false));
        final Width width = new Width(4);
        // when
        final Line line = new Line(width, testScaffoldGenerator);

        //then
        assertThat(line.getScaffolds()).containsExactly(Scaffold.EXIST, Scaffold.NONE, Scaffold.EXIST, Scaffold.NONE);
    }

    @Test
    void 연속해서_존재하는_Scaffold를_가질_수_없다() {
        // given
        final TestScaffoldGenerator testScaffoldGenerator = new TestScaffoldGenerator(List.of(true, true, true, true));
        final Width width = new Width(4);

        // when
        final Line line = new Line(width, testScaffoldGenerator);

        // then
        assertThat(line.getScaffolds()).containsExactly(Scaffold.EXIST, Scaffold.NONE, Scaffold.EXIST, Scaffold.NONE);
    }
}

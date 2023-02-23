package model;

import static org.assertj.core.api.Assertions.assertThat;

import helper.StubPassGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import strategy.PassGenerator;

@DisplayNameGeneration(ReplaceUnderscores.class)
class LineTest {

    @Nested
    class isSamePathSize_테스트 {

        @ParameterizedTest
        @MethodSource("arguments.LineArguments#provideEqualSizeLine")
        void 주어진_Line의_Path_크기가_자신과_같다면_true를_반환한다(Line firstLine, Line secondLine) {
            assertThat(firstLine.isSamePathSize(secondLine)).isTrue();
        }

        @ParameterizedTest
        @MethodSource("arguments.LineArguments#provideNonEqualSizeLine")
        void 주어진_Line의_Path_크기가_자신과_다르다면_false를_반환한다(Line firstLine, Line secondLine) {
            assertThat(firstLine.isSamePathSize(secondLine)).isFalse();
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"0:RIGHT", "1:LEFT", "2:NONE"}, delimiter = ':')
    void findDirection_메소드는_position과_paths를_전달하면_Direction을_반환한다(int position, Direction expected) {
        PassGenerator trueTrueTrueGenerator = new StubPassGenerator(List.of(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE));
        Line line = Line.of(3, trueTrueTrueGenerator);

        Direction actual = line.findDirection(position);

        assertThat(actual).isSameAs(expected);
    }
}

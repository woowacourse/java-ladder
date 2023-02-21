package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
class LineTest {

    @Nested
    class 생성자_테스트 {

        @ParameterizedTest
        @NullSource
        void 인자로_null인_컬렉션을_전달하면_예외가_발생한다(List<Path> paths) {
            assertThatThrownBy(() -> new Line(paths))
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessageContaining("사다리 경로가 정상적으로 입력되지 않았습니다.");
        }

        @ParameterizedTest
        @EmptySource
        void 인자로_비어_있는_컬렉션을_전달하면_예외가_발생한다(List<Path> paths) {
            assertThatThrownBy(() -> new Line(paths))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("1 이상의 경로를 입력해주세요.");
        }

        @ParameterizedTest
        @MethodSource("arguments.LineArguments#provideInvalidPaths")
        void 인자로_PASSABLE이_연속되는_컬렉션을_전달하면_예외가_발생한다(List<Path> paths) {
            assertThatThrownBy(() -> new Line(paths))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("사다리는 연속적으로 건널 수 없습니다.");
        }

        @ParameterizedTest
        @MethodSource("arguments.LineArguments#provideValidPaths")
        void 인자로_PASSABLE이_연속되지_않은_컬렉션을_받으면_Line을_생성한다(List<Path> paths) {
            assertThatCode(() -> new Line(paths)).doesNotThrowAnyException();
        }
    }

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
}

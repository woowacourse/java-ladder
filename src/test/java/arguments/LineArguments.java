package arguments;

import java.util.List;
import java.util.stream.Stream;
import model.Line;
import model.Path;
import org.junit.jupiter.params.provider.Arguments;

public class LineArguments {

    private static Stream<Arguments> provideInvalidPaths() {
        return Stream.of(
                Arguments.of(List.of(Path.PASSABLE, Path.PASSABLE, Path.PASSABLE)),
                Arguments.of(List.of(Path.UN_PASSABLE, Path.PASSABLE, Path.PASSABLE, Path.PASSABLE)),
                Arguments.of(List.of(Path.UN_PASSABLE, Path.UN_PASSABLE, Path.PASSABLE, Path.PASSABLE))
        );
    }

    private static Stream<Arguments> provideValidPaths() {
        return Stream.of(
                Arguments.of(List.of(Path.PASSABLE, Path.UN_PASSABLE, Path.PASSABLE)),
                Arguments.of(List.of(Path.UN_PASSABLE, Path.PASSABLE, Path.UN_PASSABLE, Path.PASSABLE)),
                Arguments.of(List.of(Path.UN_PASSABLE, Path.UN_PASSABLE, Path.PASSABLE, Path.UN_PASSABLE))
        );
    }

    private static Stream<Arguments> provideEqualSizeLine() {
        return Stream.of(
                Arguments.of(new Line(List.of(Path.PASSABLE)), new Line(List.of(Path.PASSABLE))),
                Arguments.of(new Line(List.of(Path.PASSABLE, Path.UN_PASSABLE)),
                        new Line(List.of(Path.UN_PASSABLE, Path.PASSABLE)))
        );
    }

    private static Stream<Arguments> provideNonEqualSizeLine() {
        return Stream.of(
                Arguments.of(new Line(List.of(Path.PASSABLE)), new Line(List.of(Path.PASSABLE, Path.UN_PASSABLE))),
                Arguments.of(new Line(List.of(Path.PASSABLE, Path.UN_PASSABLE)), new Line(List.of(Path.PASSABLE)))
        );
    }
}

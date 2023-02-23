package arguments;

import helper.StubPassGenerator;
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
        StubPassGenerator trueFalseGenerator = new StubPassGenerator(List.of(Boolean.TRUE, Boolean.FALSE));
        StubPassGenerator falseTrueGenerator = new StubPassGenerator(List.of(Boolean.FALSE, Boolean.TRUE));

        return Stream.of(
                Arguments.of(Line.of(2, falseTrueGenerator), Line.of(2, trueFalseGenerator)),
                Arguments.of(Line.of(2, trueFalseGenerator), Line.of(2, falseTrueGenerator))
        );
    }

    private static Stream<Arguments> provideNonEqualSizeLine() {
        StubPassGenerator trueFalseTrueGenerator = new StubPassGenerator(List.of(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE));
        StubPassGenerator trueFalseGenerator = new StubPassGenerator(List.of(Boolean.TRUE, Boolean.FALSE));

        return Stream.of(
                Arguments.of(Line.of(3, trueFalseTrueGenerator), Line.of(2, trueFalseGenerator)),
                Arguments.of(Line.of(2, trueFalseGenerator), Line.of(3, trueFalseTrueGenerator))
        );
    }
}

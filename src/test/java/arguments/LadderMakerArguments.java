package arguments;

import java.util.List;
import java.util.stream.Stream;
import model.Line;
import model.Path;
import org.junit.jupiter.params.provider.Arguments;

public class LadderMakerArguments {

    private static Stream<Arguments> provideNonEqualSizeLine() {
        return Stream.of(
                Arguments.of(new Line(List.of(Path.PASSABLE)), new Line(List.of(Path.PASSABLE, Path.UN_PASSABLE))),
                Arguments.of(new Line(List.of(Path.PASSABLE, Path.UN_PASSABLE)), new Line(List.of(Path.PASSABLE)))
        );
    }
}

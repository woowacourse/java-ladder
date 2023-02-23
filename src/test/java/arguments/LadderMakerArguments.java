package arguments;

import helper.StubPassGenerator;
import java.util.List;
import java.util.stream.Stream;
import model.Line;
import org.junit.jupiter.params.provider.Arguments;

public class LadderMakerArguments {

    private static Stream<Arguments> provideNonEqualSizeLine() {
        StubPassGenerator trueFalseTrueGenerator = new StubPassGenerator(List.of(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE));
        StubPassGenerator trueFalseGenerator = new StubPassGenerator(List.of(Boolean.TRUE, Boolean.FALSE));

        return Stream.of(
                Arguments.of(Line.of(3, trueFalseTrueGenerator), Line.of(2, trueFalseGenerator)),
                Arguments.of(Line.of(2, trueFalseGenerator), Line.of(3, trueFalseTrueGenerator))
        );
    }
}

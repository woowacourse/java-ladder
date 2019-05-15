package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserSetCrossbarGeneratorTest {
    @Test
    void name() {
        List<Boolean> userSetCrossbars = Arrays.asList(false, true, false, true, false);
        UserSetCrossbarGenerator testGenerator = new UserSetCrossbarGenerator(userSetCrossbars);

        assertThat(testGenerator.generateCrossbars()).isEqualTo(new Crossbars(userSetCrossbars));
    }
}
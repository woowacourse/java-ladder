package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserNamesTest {
    UserNames userNames;

    @Test
    void 쉼표_구분() {
        String names = "buddy,pobi,brown";
        userNames = new UserNames(names);
        List<String> results = Arrays.asList("buddy", "pobi", "brown");
        assertThat(userNames.splitNames(names)).isEqualTo(results);
    }
}

package ladder.model;

import ladder.model.MemberGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberGeneratorTest {

    @Test
    void 쉼표_구분자_분리() {
        String inputText = "pobi,crong";
        String[] result = MemberGenerator.splitByComma(inputText);
        String[] members = {"pobi", "crong"};
        assertThat(result).isEqualTo(members);
    }
}

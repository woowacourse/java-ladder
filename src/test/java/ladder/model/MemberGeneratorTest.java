package ladder.model;

import ladder.model.generator.MemberGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberGeneratorTest {

    @Test
    void 쉼표_구분자_분리() {
        String inputText = "pobi,crong";
        String[] result = MemberGenerator.refineNames(inputText);
        String[] members = {"pobi", "crong"};
        assertThat(result).isEqualTo(members);
    }

    @Test
    void 최초_사람_위치_설정() {
        String[] names = {"pobi", "honux", "crong"};
        List<Member> result = MemberGenerator.generateMembers(names);
        assertThat(result).isEqualTo(Arrays.asList(new Member("pobi", 0), new Member("honux", 1), new Member("crong", 2)));
    }
}

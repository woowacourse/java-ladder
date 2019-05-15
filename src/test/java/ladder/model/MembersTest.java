package ladder.model;

import ladder.model.Member;
import ladder.model.Members;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MembersTest {

    @Test
    void 최초_사람_위치_설정() {
        String[] names = {"pobi", "honux", "crong"};
        List<Member> result = Members.generateMembers(names);
        assertThat(result).isEqualTo(Arrays.asList(new Member("pobi"), new Member("honux"), new Member("crong")));
    }
}

package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MembersTest {

    @Test
    void 최초_사람_위치_설정() {

        Members member = new Members(Arrays.asList("pobi", "honux", "crong"));
        assertThat(member.getMembers()).isEqualTo(Arrays.asList(new Member("pobi", 0), new Member("honux", 1), new Member("crong", 2)));
    }
}

package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class MembersTest {
    @Test
    void 시작위치() {
        Member a = new Member("a", 0);
        Member b = new Member("b", 1);
        Member c = new Member("c", 2);
        Members member = new Members(Arrays.asList("a", "b", "c"));
        assertThat(member.getMembers()).isEqualTo(Arrays.asList(a, b, c));
    }
}

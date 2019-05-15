package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberTest {
    @Test
    void 생성() {
        Member member = new Member("철시");
        assertThat(member).isEqualTo(new Member("철시"));
    }
}

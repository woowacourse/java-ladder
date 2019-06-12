package ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberTest {
    Member member;

    @BeforeEach
    void setUp() {
        member = new Member("abc", 1);
    }

    @Test
    void 생성() {
        assertThat(member).isEqualTo(new Member("abc", 1));
    }
}

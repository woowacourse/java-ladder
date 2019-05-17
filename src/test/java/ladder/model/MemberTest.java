package ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberTest {
    Member member;

    @BeforeEach
    void setUp() {
        member = new Member("철시", 1);
    }

    @Test
    void 생성() {
        assertThat(member).isEqualTo(new Member("철시", 1));
    }

    @Test
    void 우측_이동_확인() {
        member.move(true, 1);
        int result = member.getPosition();
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 좌측_이동_확인() {
        member.move(true, 0);
        int result = member.getPosition();
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 정지_확인() {
        member.move(false, 1);
        int result = member.getPosition();
        assertThat(result).isEqualTo(1);
    }
}

package ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MembersTest {

    Members members;

    @BeforeEach
    void setUp() {
        members = new Members(Arrays.asList(new Member("pobi", 0), new Member("crong", 1),
                        new Member("honux", 2), new Member("jk", 3)));
    }

    @Test
    void 생성() {
        assertThat(members).isEqualTo(new Members(Arrays.asList(new Member("pobi", 0), new Member("crong", 1),
                new Member("honux", 2), new Member("jk", 3))));
    }

    @Test
    void Member의_수가_4인지_테스트() {
        assertThat(members.numberOfMembers()).isEqualTo(4);
    }
}

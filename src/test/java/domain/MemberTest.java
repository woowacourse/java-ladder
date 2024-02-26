package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberTest {

    @Test
    @DisplayName("멤버 객체 생성 성공")
    void test_ok_constructor() {
        assertThat(Member.from(0, "name").getName()).isEqualTo("name");
    }
}

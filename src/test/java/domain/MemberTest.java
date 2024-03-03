package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberTest {

    @Test
    @DisplayName("Member 객체 생성 성공")
    void test_ok_constructor() {
        assertThat(Member.from("name").getName()).isEqualTo("name");
    }
}

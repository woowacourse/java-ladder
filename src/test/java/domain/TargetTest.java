package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TargetTest {

    @Test
    @DisplayName("대상 객체 생성 성공")
    void test_ok_constructor() {
        Target target = Target.of("t1",
                List.of(new Member("t1"), new Member("t2")));
        assertThat(target.getName()).isEqualTo("t1");
        assertThat(target.isAllMembers()).isFalse();
    }

    @Test
    @DisplayName("대상 객체 생성 성공 - 전체를 나타내는 객체")
    void test_ok_constructorAll() {
        Target target = Target.of("all",
                List.of(new Member("m1"), new Member("m2")));
        assertThat(target.getName()).isEqualTo("all");
        assertThat(target.isAllMembers()).isTrue();
    }

    @Test
    @DisplayName("대상 객체 생성 실패 - 해당 이름을 가진 참여자 없음")
    void test_exception_constructorNotContain() {
        assertThatThrownBy(() -> Target.of("m3",
                List.of(new Member("m1"), new Member("m2"))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTargetTest {

    @Test
    @DisplayName("대상 객체 생성 성공")
    void test_ok_constructor() {
        ResultTarget resultTarget = ResultTarget.of("t1",
                List.of(new Member("t1"), new Member("t2")));
        assertThat(resultTarget.getValue()).isEqualTo("t1");
        assertThat(resultTarget.isAllMembers()).isFalse();
    }

    @Test
    @DisplayName("대상 객체 생성 성공 - 전체를 나타내는 객체")
    void test_ok_constructorAll() {
        ResultTarget resultTarget = ResultTarget.of("all",
                List.of(new Member("m1"), new Member("m2")));
        assertThat(resultTarget.getValue()).isEqualTo("all");
        assertThat(resultTarget.isAllMembers()).isTrue();
    }

    @Test
    @DisplayName("대상 객체 생성 실패 - 해당 이름을 가진 참여자 없음")
    void test_exception_constructorNotContain() {
        assertThatThrownBy(() -> ResultTarget.of("m3",
                List.of(new Member("m1"), new Member("m2"))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

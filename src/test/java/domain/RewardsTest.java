package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RewardsTest {

    @Test
    @DisplayName("결과 객체 생성 성공: 성공적으로 도메인이 생성된다.")
    void test_ok_createObject() {
        Rewards rewards = Rewards.of(List.of("1", "2"), 2);
        assertThat(rewards.getValues())
                .hasSize(2)
                .containsExactly("1", "2");
    }

    @Test
    @DisplayName("결과 객체 생성 실패: 참여자 수와 개수가 같지 않으면 에러를 반환한다.")
    void test_exception_NotEqualCount() {
        Members members = Members.from(List.of("a", "b", "c", "d"));
        assertThatCode(() -> Rewards.of(List.of("1", "2", "3"), members.getCount()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("결과의 수는 참여자의 수와 같아야 합니다.");
    }
}

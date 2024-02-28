package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RewardsTest {

    @Test
    @DisplayName("Rewards 생성 성공: 사람 수 만큼 입력")
    void test_ok() {
        assertThatCode(() -> Rewards.from(4, "꽝,1000,꽝,1000"))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("Rewards 생성 성공: 쉼표 좌우 공백 정상 처리")
    void test_ok_namesWithSpace() {
        assertThatCode(() -> Rewards.from(4, "  꽝 , 1000 ,  꽝 , 1000 "))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("Rewards 생성 실패: 비정상 공백 처리")
    void test_exception_namesWithSpace() {
        assertThatCode(() -> Rewards.from(4, "꽝,1000,꽝,10 00"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("숫자 혹은 '꽝'만 입력 가능합니다.");
    }

    @Test
    @DisplayName("Rewards 생성 실패: 사람 수에 맞지 않게 입력")
    void test_exception_doesntMatchMemberCount() {
        assertThatThrownBy(() -> Rewards.from(3, "꽝,1000,꽝,1000"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("플레이어 수(3)만큼 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {",,꽝,1000", "꽝,1000,,", ",꽝,1000,", ",,,"})
    @DisplayName("Rewards 생성 실패: 올바르지 않은 쉼표 입력")
    void test_exception_illegalDelimiter(String rawNames) {
        assertThatThrownBy(() -> Rewards.from(4, rawNames))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Rewards 생성 실패: null")
    void test_exception_null() {
        assertThatThrownBy(() -> Rewards.from(1, null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("null을 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("Rewards 생성 실패: empty")
    void test_exception_empty() {
        assertThatThrownBy(() -> Rewards.from(1, ""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("빈 문자열을 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("성공: 인덱스로 Reward의 이름을 찾을 수 있다.")
    void findRewardNameByIndex() {
        Rewards rewards = Rewards.from(3, "꽝,10,20");
        Assertions.assertAll(
            () -> assertThat(rewards.findRewardNameByIndex(0)).isEqualTo("꽝"),
            () -> assertThat(rewards.findRewardNameByIndex(1)).isEqualTo("10"),
            () -> assertThat(rewards.findRewardNameByIndex(2)).isEqualTo("20")
        );
    }


    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    @DisplayName("실패: 인덱스가 넘어가는 경우 에러 처리한다.")
    void findRewardNameByIndex_exception(int index) {
        Rewards rewards = Rewards.from(3, "꽝,10,20");
        assertThatThrownBy(() -> rewards.findRewardNameByIndex(index))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("올바르지 않은 상품 인덱스입니다.");
    }

}

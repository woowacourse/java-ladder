package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RewardsTest {

    @Test
    @DisplayName("성공: findRewardById 테스트")
    void findRewardById() {
        Rewards rewards = Rewards.from(3, "1,2,3");
        Reward reward0 = rewards.findRewardById(0);
        Reward reward1 = rewards.findRewardById(1);
        Reward reward2 = rewards.findRewardById(2);
        Assertions.assertAll(
            () -> assertThat(reward0.getName()).isEqualTo("1"),
            () -> assertThat(reward1.getName()).isEqualTo("2"),
            () -> assertThat(reward2.getName()).isEqualTo("3")
        );
    }

    @Test
    @DisplayName("Rewards 객체 생성 성공: 사람 수 만큼 입력")
    void rewards_ok() {
        assertThatCode(() -> Rewards.from(4, "꽝,1000,꽝,1000"))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("Rewards 객체 생성 성공: 쉼표 좌우 공백 정상 처리")
    void rewards_ok_namesWithSpace() {
        assertThatCode(() -> Rewards.from(4, "  꽝 , 1000 ,  꽝 , 1000 "))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("Rewards 객체 생성 실패: 비정상 공백 처리")
    void rewards_exception_namesWithSpace() {
        assertThatCode(() -> Rewards.from(4, "꽝,1000,꽝,10 00"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Rewards 객체 생성 실패: 사람 수에 맞지 않게 입력")
    void rewards_exception_doesntMatchMemberCount() {
        assertThatThrownBy(() -> Rewards.from(3, "꽝,1000,꽝,1000"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {",,꽝,1000", "꽝,1000,,", ",꽝,1000,", ",,,"})
    @DisplayName("Rewards 객체 생성 실패: 올바르지 않은 쉼표 입력")
    void rewards_exception_illegalDelimiter(String rawNames) {
        assertThatThrownBy(() -> Rewards.from(4, rawNames))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @DisplayName("Rewards 객체 생성 실패: null, empty")
    void rewards_exception_null_empty(String rawNames) {
        assertThatThrownBy(() -> Rewards.from(1, rawNames))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("인덱스로 Reward의 이름 찾기 성공")
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
    @DisplayName("인덱스로 Reward의 이름 찾기 실패")
    void findRewardNameByIndex_exception(int index) {
        Rewards rewards = Rewards.from(3, "꽝,10,20");
        assertThatThrownBy(() -> rewards.findRewardNameByIndex(index))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("올바르지 않은 상품 인덱스입니다.");
    }

}

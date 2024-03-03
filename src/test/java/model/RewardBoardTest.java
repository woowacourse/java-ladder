package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RewardBoardTest {

    @Test
    @DisplayName("참가자의 이름을 바탕으로 경품을 조회한다.")
    void findOneTest() {
        //given
        RewardBoard board = new RewardBoard();

        //when
        board.addReward(new Person("프람"), new Prize("치킨"));
        board.addReward(new Person("폰드"), new Prize("피자"));
        Prize findPrize = board.findPrizeByName("프람");

        //then
        assertThat(findPrize)
                .isEqualTo(new Prize("치킨"));
    }

    @Test
    @DisplayName("없는 참가자를 찾을 때 예외를 발생시킨다.")
    void findNothingOneTest() {
        //given
        RewardBoard board = new RewardBoard();

        //when & then
        assertThatThrownBy(() -> board.findPrizeByName("프람"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("추가 된 이름 순서대로 경품들을 반환한다.")
    void findAllTest() {
        //given
        RewardBoard board = new RewardBoard();
        List<Prize> expect = List.of(new Prize("치킨"), new Prize("피자"), new Prize("족발"));

        //when
        board.addReward(new Person("프람"), new Prize("치킨"));
        board.addReward(new Person("도비"), new Prize("피자"));
        board.addReward(new Person("조이썬"), new Prize("족발"));

        List<Prize> actual = board.findAllPrizes();
        //then
        assertThat(actual)
                .isEqualTo(expect);
    }

}

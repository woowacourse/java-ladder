package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

/**
 * 사다리 게임 참여자 정보를 가지는 클래스.
 * 원시타입 데이터의 getter는 테스트하지 않는다.
 */
public class PlayerTest {
    @Test
    @DisplayName("Player 객체 생성 성공 테스트")
    void createPlayerTest() {
        Assertions.assertThatNoException().isThrownBy(() -> new Player(new Name("pobi")));
    }

    @Test
    @DisplayName("참여자의 이름 정보가 일치하는지 확인할 수 있는 기능 테스트")
    void isPlayerNameTest() {
        //given
        Player player = new Player(new Name("pobi"));

        //when
        boolean result = player.isPlayerName(new Name("pobi"));

        //then
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("사다리 게임의 개인 결과를 저장하는 기능 테스트")
    void savePlayerResultTest() {
        //given
        Player player = new Player(new Name("pobi"));
        Result result = new Result("5000");

        //when
        player.saveResult(result);

        //then
        assertThat(player.getResult()).isEqualTo("5000");
    }
}

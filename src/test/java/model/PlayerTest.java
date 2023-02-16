package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class PlayerTest {

    @Test
    @DisplayName("Player 객체 생성 성공 테스트")
    void createPlayerTest(){
        Assertions.assertThatNoException().isThrownBy(()->{Player player = new Player(new Name("pobi"));});
    }

    @Test
    @DisplayName("참여자의 이름 정보를 조회할 수 있는 기능 테스트")
    void getPlayerNameTest() {
        //Given
        Player player = new Player(new Name("pobi"));

        //When
        Name result = player.getName();

        //Then
        assertThat(result).isEqualTo(new Name("pobi"));
    }
}

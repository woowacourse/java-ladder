package domain.model;

import domain.vo.Name;
import domain.vo.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayerTest {

    @Test
    @DisplayName("참가자 생성 테스트")
    void playerTest(){
        Name name = new Name("test");
        Position position = new Position(1);
        Player player = new Player(name,position);
        assertThat(player.getName()).isEqualTo("test");
        assertThat(player.getPosition()).isEqualTo(1);
    }
}

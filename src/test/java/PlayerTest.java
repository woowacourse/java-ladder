import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class PlayerTest {
    @Test
    @DisplayName("이름을 통해 사용자를 생성한다.")
    public void createPlayer(){
        Name name = new Name("포비");

        Player player = new Player(name);
        assertEquals(player.getName(),name);
    }
}

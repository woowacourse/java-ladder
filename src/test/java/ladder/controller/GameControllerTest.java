package ladder.controller;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameControllerTest {
    @Test
    public void 최소참가자체크(){
        assertThrows(IllegalArgumentException.class,() -> {
           new GameController().registParticipant(Arrays.asList("A"));
        });
    }

    @Test
    public void 중복참가자(){
        assertThrows(IllegalArgumentException.class,()->{
            new GameController().registParticipant(Arrays.asList("포비","포비"));
        });
    }

    /*@Test
    public void 사다리게임결과얻기(){
        GameController ladderController = new GameController();
        ladderController.registParticipant(Arrays.asList("a","b","c"));
        ladderController.makeLadder(5);

    }
*/
}

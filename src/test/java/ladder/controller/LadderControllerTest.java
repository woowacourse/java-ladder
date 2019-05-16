package ladder.controller;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderControllerTest {
    @Test
    public void 최소참가자체크테스트(){
        assertThrows(IllegalArgumentException.class,() -> {
           new GameController().registParticipant(Arrays.asList("A"));
        });
    }

    @Test
    public void 중복참가자테스트(){
        assertThrows(IllegalArgumentException.class,()->{
            new GameController().registParticipant(Arrays.asList("포비","포비"));
        });
    }

}

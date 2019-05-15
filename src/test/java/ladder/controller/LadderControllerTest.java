package ladder.controller;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderControllerTest {
    @Test
    public void 최소참가자체크테스트(){
        assertThrows(IllegalArgumentException.class,() -> {
           new LadderController().registParticipant(Arrays.asList("A"));
        });
    }
}

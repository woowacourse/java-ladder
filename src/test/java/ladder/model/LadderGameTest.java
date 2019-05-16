package ladder.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderGameTest {
    @Test
    void 찾을_플레이어_존재_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            (new LadderGame(new PlayerTags("pobi,coogi,luffy"),new ResultTags("1,2,3",3),new Floor("3")))
                    .getOneResultByTag(new Tag("jason"));
        });
    }
}
package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderGameTest {

    @Test
    void 문자열_유저_리스트_반환() {
        assertThat(new LadderGame("pobi,crong", 1).getUsers()).isEqualTo(Arrays.asList(new User("pobi", 0), new User("crong", 1)));
        assertThat(new LadderGame("pobi", 1).getUsers()).isEqualTo(Arrays.asList(new User("pobi", 0)));
    }

    @Test
    void 사다리_높이_추가() {
        assertThat(new LadderGame("pobi,crong", 5).getHeight()).isEqualTo(5);
        assertThat(new LadderGame("pobi", 4).getHeight()).isEqualTo(4);
    }

    @Test
    void 사다리_높이_음수일_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderGame("pobi,crong", -1);
        });
    }

}

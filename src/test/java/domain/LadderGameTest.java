package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderGameTest {

    @Test
    void 문자열_유저_리스트_반환() {
        assertThat(new LadderGame("pobi,crong").getUsers()).isEqualTo(Arrays.asList(new User("pobi"), new User("crong")));
        assertThat(new LadderGame("pobi").getUsers()).isEqualTo(Arrays.asList(new User("pobi")));
    }
}

package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RewardsTest {
    Players players = new Players(Arrays.asList("abc", "def", "ghi"));

    @Test
    void initTestA() {
        assertThat(new Rewards(players, Arrays.asList("ABC")).toString()).isEqualTo("ABC, 꽝, 꽝");
    }

    @Test
    void initTestB() {
        assertThat(new Rewards(players, Arrays.asList()).toString()).isEqualTo("꽝, 꽝, 꽝");
    }

    @Test
    void initTestC() {
        assertThat(new Rewards(players, Arrays.asList("ABC", "12 ", "34", "56")).toString()).isEqualTo("ABC, 12, 34");
    }

    @Test
    void initTestD() {
        assertThat(new Rewards(players, Arrays.asList(" ABC      ", "123 ")).toString()).isEqualTo("ABC, 123, 꽝");
    }

    @Test
    void longestLengthTest() {
        assertThat(new Rewards(players, Arrays.asList("abc", "bcd", "cdef", "g")).getLongestRewardNameLength()).isEqualTo(4);
    }
}
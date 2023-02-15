package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PeopleCountTest {
    private PeopleCount peopleCount;

    @BeforeEach
    void setUp() {
        peopleCount = new PeopleCount(1);
    }

    @Test
    @DisplayName("isEnd()는 peopleCount와 currentCount가 다른 경우 false를 반환한다. ")
    void test_1() {
        // then
        assertThat(peopleCount.isEnd()).isFalse();
    }

    @Test
    @DisplayName("isEnd()는 peopleCount와 currentCount가 같은 경우 true를 반환한다. ")
    void test_2() {
        // given & when
        peopleCount.counting();

        // then
        assertThat(peopleCount.isEnd()).isTrue();
    }
}

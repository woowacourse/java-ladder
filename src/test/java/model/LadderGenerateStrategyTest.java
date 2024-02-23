package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderGenerateStrategyTest {

    @DisplayName("인자의 개수 만큼 랜덤한 값으로 구성된 리스트를 반환할 수 있다.")
    @RepeatedTest(100)
    void apply() {
        int randomNumber = new Random().nextInt(10) + 1;
        List<Boolean> result = new LadderGenerateStrategy().apply(randomNumber);
        assertAll(
                () -> assertThat(result).containsAnyOf(true, false),
                () -> assertThat(result.size()).isEqualTo(randomNumber)
        );

    }

}
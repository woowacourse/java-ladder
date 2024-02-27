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
        Integer rowCount = 5;
        Integer columnCount = 7;
        List<List<Boolean>> result = new LadderGenerateStrategy().apply(rowCount, columnCount);
        for (int i = 0; i < columnCount; i++) {
            List<Boolean> row = result.get(i);
            assertAll(
                    () -> assertThat(row).containsAnyElementsOf(List.of(true, false)),
                    () -> assertThat(row.size()).isEqualTo(rowCount)
            );
        }


    }

}

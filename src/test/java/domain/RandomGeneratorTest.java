package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGeneratorTest {
    @DisplayName("커스텀 랜덤생성기가 정상적으로 동작하는지 테스트합니다.")
    @Test
    void generateRandomNumbers() {
        Queue<Boolean> randomNumber = new LinkedList<>();
        Arrays.asList(true, false, false, true, false, false).forEach(randomNumber::add);
        BooleanGenerator customRandomGenerator = new CustomRandomGenerator(randomNumber);

        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < randomNumber.size(); i++) {
            result.add(customRandomGenerator.get());
        }

        assertThat(result).isEqualTo(randomNumber);
    }
}

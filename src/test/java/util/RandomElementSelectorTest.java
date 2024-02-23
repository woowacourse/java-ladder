package util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("컬렉션 랜덤 요소 선택 기능 테스트")
class RandomElementSelectorTest {

    @DisplayName("컬렉션의 요소 중 랜덤하게 뽑은 요소는 원래 컬렉션에 들어있던 요소이다")
    @Test
    void testSelectedRandomIsInOriginCollection() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        int random = RandomElementSelector.selectRandomElement(numbers);
        assertThat(random).isIn(numbers);
    }
}

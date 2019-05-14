package stringadder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegerAdderTest {
    @Test
    void List안의_숫자들의_합을_반환하는지_테스트() {
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3));
        assertThat(IntegerAdder.add(integers)).isEqualTo(6);

        integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertThat(IntegerAdder.add(integers)).isEqualTo(10);
    }
}

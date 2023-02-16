package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class NamesTest {

    @Test
    @DisplayName("Names 객체 생성 성공 테스트")
    void createNamesTest() {
        Names names = new Names(Arrays.asList("pobi", "crong", "honux"));

        assertThat(names.getNames().size()).isEqualTo(3);
    }

}

package model;

import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NamesTest {

    @Test
    @DisplayName("Names 객체 생성 성공 테스트")
    void createNamesTest() {
        assertThatNoException().isThrownBy(()->{
            Names names = new Names("pobi, neo, conan");});
    }

}

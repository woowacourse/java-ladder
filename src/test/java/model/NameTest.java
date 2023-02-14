package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    @DisplayName("Name 객체 생성 성공 테스트")
    void createNameTest(){
        Assertions.assertThatNoException().isThrownBy(()->{Name name = new Name("ocean");});
    }

}

package domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

// TODO :  DisplayName 작성해주기
public class NameTest {

    @Test
    void constructSuccessTest(){
        assertThatNoException()
                .isThrownBy(() -> new Name("takan"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void constructFailWithBlankName(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructFailBecauseNameLength(){
        //TODO : 테스트 이름 변경
        assertThatThrownBy(() -> new Name("zangsu"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

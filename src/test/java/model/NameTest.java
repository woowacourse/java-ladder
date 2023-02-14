package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class NameTest {

    @Test
    @DisplayName("Name 객체 생성 성공 테스트")
    void createNameTest(){
        Assertions.assertThatNoException().isThrownBy(()->{Name name = new Name("ocean");});
    }

    @Test
    @DisplayName("이름 값 길이 제한으로 인한 Player 객체 생성 실패 테스트")
    void limitPlayerNameLengthTest(){
        //When
        Throwable result = catchThrowable(()->{Name name = new Name("woowacourse");});

        //Then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

}

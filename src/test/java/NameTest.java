import domain.player.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {
    @Test
    @DisplayName("문자열을 통해 이름을 생성한다.")
    public void createName(){
        //Given
        String value = "도비";

        //When
        Name name = new Name(value);

        //Then
        assertInstanceOf(Name.class,name);
        assertEquals(name.getValue(),value);
    }

    @Test
    @DisplayName("다섯글자를 초과한 문자열을 통한 생성은 예외를 발생한다.")
    public void throwExceptionWhenInputStringIsOverThan5(){
        String value = "longName";

        assertThrows(IllegalArgumentException.class,() -> new Name(value));
    }

    @ParameterizedTest
    @DisplayName("눈에 보이지 않는 공백들로 이루어진 생성은 예외를 발생한다.")
    @ValueSource(strings = {""," "})
    public void throwExceptionWhenInputStringHasBlank(String value){
        assertThrows(IllegalArgumentException.class,() -> new Name(value));
    }

    @ParameterizedTest
    @DisplayName("공백이 포함된 문자열을 이용한 생성은 예외를 발생한다.")
    @ValueSource(strings = {"d obby","j o y", "도  비"})
    public void throwExceptionWhenInputStringContainsBlank(String value){
        assertThrows(IllegalArgumentException.class,() -> new Name(value));
    }
}

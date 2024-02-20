import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NamesTest {
    @Test
    @DisplayName("이름 목록을 포함한 일급 컬렉션을 만든다.")
    public void createNames(){
        //Given
        List<String> value = List.of("도비","조이썬");

        //When
        Names names = Names.from(value);

        //Then
        assertInstanceOf(Names.class,names);
    }
}
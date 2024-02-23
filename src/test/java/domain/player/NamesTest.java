package domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NamesTest {
    @Test
    @DisplayName("이름 목록을 포함한 일급 컬렉션을 만든다.")
    public void createNames() {
        //Given
        List<String> value = List.of("도비", "조이썬");

        //When
        Names names = Names.from(value);

        //Then
        assertInstanceOf(Names.class, names);
    }

    @Test
    @DisplayName("중복된 플레이어의 이름이 포함된 목록은 예외를 발생한다.")
    public void throwExceptionWhenDuplicatedNameInput() {

        List<String> value = List.of("도비", "도비", "조이썬");

        assertThrows(IllegalArgumentException.class, () -> {
            Names.from(value);
        });
    }

    @Test
    @DisplayName("2명 미만의 이름이 포함된 목록은 예외를 발생한다.")
    public void throwExceptionWhenNameInputLessThanTwo() {
        List<String> value = List.of("도비");
        assertThrows(IllegalArgumentException.class, () -> Names.from(value));
    }
}

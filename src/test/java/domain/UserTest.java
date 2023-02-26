package domain;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = User.of(
            Name.from("joy"),
            Position.from(0));
    }

    @DisplayName("입력 받은 수들 중에 현재 사용자의 위치와 동일하거나 1만큼 작은 경우 위치가 변화한다.")
    @Test
    void movePosition() {
        List<Integer> numbers = List.of(0, 1, 1);
        user.movePosition(numbers);

        assertEquals(1, user.getPosition());
    }

}
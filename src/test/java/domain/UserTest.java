package domain;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User(
            new Name("joy"),
            new Position(0));
    }

    @Test
    void movePosition() {
        List<Integer> numbers = List.of(0, 1, 1);
        user.movePosition(numbers);

        assertEquals(1, user.getPosition());
    }

}
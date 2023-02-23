package domain;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UsersTest {

    Users users;

    @BeforeEach
    void setUp() {
        users = new Users(List.of(
            new User(new Name("joy"), new Position(0)),
            new User(new Name("pobi"), new Position(1)),
            new User(new Name("crong"), new Position(2)))
        );
    }

    @DisplayName("이름과 동일한 참여자를 찾는다.")
    @ParameterizedTest
    @ValueSource(strings = {"joy", "pobi", "crong"})
    void findUser(String name) {
        assertEquals(name, users.findUser(name).getName());
    }

    @DisplayName("입력되는 사다리 가로선의 인덱스에 따라 사용자의 위치는 변화한다.")
    @ParameterizedTest
    @ValueSource(strings = {"joy"})
    void moveUsers(String name) {
        List<List<Integer>> allNumbers = List.of(
            List.of(0, 1),
            List.of(3),
            List.of(1, 3)
        );

        users.moveUsers(allNumbers);
        assertEquals(2, users.findUser(name).getPosition());
    }

}
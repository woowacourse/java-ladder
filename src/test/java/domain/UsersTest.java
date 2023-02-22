package domain;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
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

    @ParameterizedTest
    @ValueSource(strings = {"joy", "pobi", "crong"})
    void findUser(String name) {
        assertEquals(name, users.findUser(name).getName());
    }

}
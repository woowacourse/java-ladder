package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerFactoryTest {

    @Test
    void createAll_중복된이름존재() {
        List<String> names = Arrays.asList("hello", "hello");

        assertThrows(DuplicatedNameException.class, () -> PlayerFactory.createAll(names));
    }
}
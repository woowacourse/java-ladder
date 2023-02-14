package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PlayerTest {

    @Test
    void 플레이어의_이름은_최대_5글자까지_부여할_수_있다(){
        String name = "judith";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
           new Player(name);
        });
    }
}

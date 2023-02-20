package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
class LadderGameTest {

    private LadderGame ladderGame;

    @BeforeEach
    void init() {
        ladderGame = new LadderGame();
    }

    @DisplayName("이름을 입력 받았을 때 Peoples 객체가 생성되어야 한다.")
    @Test
    void PEOPLES_객체_생성() {
        List<String> names = List.of("p1", "p2", "p3");
        Person person = ladderGame.createPeoples(names);

        Assertions.assertAll(
                () -> {
                    for (int i = 0; i < names.size(); i++) {
                        assertEquals(person.getPerson().get(i).getName(), names.get(i));
                    }
                }
        );
    }

    @DisplayName("라인들을 받았을 때 Lines 객체가 생성되어야 한다.")
    @Test
    void LINES_객체_생성() {
        final int height = 3;
        final int width = 3;
        Lines lines = ladderGame.createLines(width, height);

        Assertions.assertAll(
                () -> {
                    assertEquals(lines.getClass(), Lines.class);
                    assertEquals(lines.getLines().size(), height);
                }
        );
    }
}

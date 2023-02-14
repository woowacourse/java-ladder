package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
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
        List<String> names = List.of("people1", "people2", "people3");
        Peoples peoples = ladderGame.createPeoples(names);

        Assertions.assertAll(
                () -> {
                    assertEquals(peoples.getPeoples().get(0).getName(), "people1");
                    assertEquals(peoples.getPeoples().get(1).getName(), "people2");
                    assertEquals(peoples.getPeoples().get(2).getName(), "people3");
                }
        );
    }
}
package ladder.view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerExceptionTest {
    @Test
    void playerNames_빈값_예외_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            PlayerException.playerNames("");
        });
    }

    @Test
    void playerNames_스페이스_예외_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            PlayerException.playerNames(" ");
        });
    }

    @Test
    void playerNames_빈값_두개_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            PlayerException.playerNames(" , ");
        });
    }

    @Test
    void playerNames_앞에_빈값_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            PlayerException.playerNames(", hee");
        });
    }

    @Test
    void playerNames_중간_빈값_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            PlayerException.playerNames("hee , ,gi");
        });
    }

    @Test
    void playerNames_6자이상_예외_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            PlayerException.playerNames("heebong");
        });
    }

    @Test
    void playerNameOverLength_빈값_예외_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            PlayerException.playerNameOverLength("");
        });
    }

    @Test
    void playerNameOverLength_6글자_예외_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            PlayerException.playerNameOverLength("sdfghs");
        });
    }

    @Test
    void playersMinCount_0_예외_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            PlayerException.playersMinCount(0);
        });
    }

    @Test
    void playerNames_중복_이름_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            PlayerException.playerNames("1,2,3,2");
        });
    }

    @Test
    void playerNames_all이름_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            PlayerException.playerNames(" all , hee, hi");
        });
    }
}

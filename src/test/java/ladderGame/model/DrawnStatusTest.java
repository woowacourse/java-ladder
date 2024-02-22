package ladderGame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrawnStatusTest {

    @Test
    @DisplayName("DrawnStatus가 DRAWN이면 true를 반환한다.")
    void checkDrawnIsTrue() {
        DrawnStatus drawnStatus = DrawnStatus.DRAWN;

        assertTrue(drawnStatus.equals(DrawnStatus.DRAWN));
    }

    @Test
    @DisplayName("DrawnStatus가 NON_DRAWN이면 false를 반환한다.")
    void checkNonDrawnIsFalse() {
        DrawnStatus drawnStatus = DrawnStatus.NON_DRAWN;

        assertFalse(drawnStatus.equals(DrawnStatus.DRAWN));
    }

}
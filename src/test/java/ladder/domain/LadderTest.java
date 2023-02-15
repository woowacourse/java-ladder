package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {

    @Test
    @DisplayName("0이하의 값으로 Ladder생성시 예외가 발생한다.")
    void inValidLadderSizeTest(){
        assertThatThrownBy(()-> new Ladder(0, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1이상의 값으로 Ladder생성 시 사이즈 테스트")
    void checkValidLadderSizeTest(){
        assertThat(new Ladder(3, 1).getFloors().size())
                .isEqualTo(3);
    }

    @Test
    @DisplayName("Ladder 가로 사이즈 테스트")
    void checkLadderWidthTest() {
        Ladder ladder = new Ladder(3, 2);
        List<Floor> floors = ladder.getFloors();

        for (Floor floor : floors) {
            assertThat(floor.getLines().size()).isEqualTo(2);
        }
    }

    @Test
    @DisplayName("Ladder 1층 생성 테스트")
    void makeFirstFloorTest(){
        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(List.of(1,0,0));

        Ladder ladder = new Ladder(1,3);
        ladder.makeFloors(testNumberGenerator);

        Floor firstFloor = ladder.getFloors().get(0);

        assertThat(firstFloor.getLines().get(0).isExist()).isEqualTo(true);
        assertThat(firstFloor.getLines().get(1).isExist()).isEqualTo(false);
        assertThat(firstFloor.getLines().get(2).isExist()).isEqualTo(false);
    }

    
}

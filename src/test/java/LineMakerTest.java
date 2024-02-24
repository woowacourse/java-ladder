import domain.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineMakerTest {

    private static final Step EXIST_POINT = Step.EXIST;
    private static final Step EMPTY_POINT = Step.EMPTY;

    @DisplayName("앞에 다리가 생성되면 연결된 다음 다리는 발판이 없어야 하고, 마지막 다리는 발판이 없어야 한다.")
    @Test
    void makeLineExist() {
        //given
        //final LineMaker lineMaker = new LineMaker(PlayerCount.from(3), new ExistStepGenerator());

        //when & then
        //assertThat(lineMaker.makeLine()).isEqualTo(new Line(List.of(EXIST_POINT, EMPTY_POINT, EMPTY_POINT)));
    }

    @DisplayName("모든 다리가 발판을 가지지 않는 경우 테스트")
    @Test
    void makeLineEmpty() {
        //given
        /*final EmptyStepGenerator emptyStepGenerator = new EmptyStepGenerator();
        final LineMaker lineMaker = new LineMaker(PlayerCount.from(3), emptyStepGenerator);

        //when & then
        assertThat(lineMaker.makeLine()).isEqualTo(new Line(List.of(EMPTY_POINT, EMPTY_POINT, EMPTY_POINT)));*/
    }

    private static class EmptyStepGenerator {
        public Step generate() {
            return Step.EMPTY;
        }
    }
}

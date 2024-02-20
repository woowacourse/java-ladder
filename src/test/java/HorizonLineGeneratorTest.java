import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HorizonLineGeneratorTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        Assertions.assertThatCode(() -> new HorizonLineGenerator())
                .doesNotThrowAnyException();
    }

    @DisplayName("0을 입력하면 EMPTY 라인을 반환한다.")
    @Test
    void generateEmptyLine() {
        HorizonLineGenerator horizonLineGenerator = new HorizonLineGenerator();

        HorizonLine horizonLine = horizonLineGenerator.generate(0);

        Assertions.assertThat(horizonLine).isEqualTo(HorizonLine.EMPTY);
    }
}

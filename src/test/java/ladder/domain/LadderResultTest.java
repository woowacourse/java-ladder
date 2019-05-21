package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultTest {
    @Test
    void LadderResult에_결과가_정상적으로_들어가는지_테스트() {
        LadderResult lAdderResult = new LadderResult();
        lAdderResult.addResult(new Player("van"), new ResultItem("a"));
        assertThat(lAdderResult.getResultOf("van")).isEqualTo(new ResultItem("a"));
    }

    @Test
    void all을_입력할_경우_모든_결과를_리턴해_준다() {
        LadderResult lAdderResult = new LadderResult();
        lAdderResult.addResult(new Player("a"), new ResultItem("1"));
        lAdderResult.addResult(new Player("b"), new ResultItem("2"));
        lAdderResult.addResult(new Player("c"), new ResultItem("3"));
        assertThat(lAdderResult.getResultAll().size()).isEqualTo(3);
    }
}

package calculator.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionTest {

    private Expression expression;

    @Test
    public void 계산기클래스가_제대로_생성되는지() {
        expression = new Expression("1");
        assertThat(expression).isEqualTo(new Expression("1"));
    }

    @Test
    public void 문자열_분리를_쉼표로_제대로_하는지() {
        expression = new Expression("1,2,3");
        assertThat(expression.splitExpression()).isEqualTo(Arrays.asList("1", "2", "3"));
    }

    @Test
    public void 문자열_분리를_콜론으로_제대로_하는지() {
        expression = new Expression("1:2:3");
        assertThat(expression.splitExpression()).isEqualTo(Arrays.asList("1", "2", "3"));
    }

    @Test
    public void 문자열_분리를_쉼표와_콜론으로_제대로_하는지() {
        expression = new Expression("1,2:3");
        assertThat(expression.splitExpression()).isEqualTo(Arrays.asList("1", "2", "3"));
    }

    @Test
    public void 커스텀_구분자로_분리를_제대로_하는지() {
        expression = new Expression("//;\n1;2;3");
        assertThat(expression.splitExpression()).isEqualTo(Arrays.asList("1", "2", "3"));
    }

    @Test
    public void 문자열을_넘버의_리스트로_제대로_생성하는지() {
        expression = new Expression("//a\n4a3a2");
        assertThat(expression.getNumbers())
                .isEqualTo(Arrays.asList(new Number("4"), new Number("3"), new Number("2")));
    }
}
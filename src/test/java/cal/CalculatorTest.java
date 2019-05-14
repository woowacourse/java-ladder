package cal;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    void 숫자_하나(){
        int result = Calculator.calculate("1");
        assertThat(result).isEqualTo(1);
    }
    @Test
    void 구분자_한종류(){
        int result = Calculator.calculate("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 구분자_두종류(){
        int result = Calculator.calculate("1,2;3");
        assertThat(result).isEqualTo(6);
    }



//    @Test
//    public void 스플릿_테스트(){
//        List<String> separator = new ArrayList<>(Arrays.asList(",",";"));
//        String input = "1,2;3";
//        assertThat(separate(separator,input)).isEqualTo(new List<String>(Arrays.asList("1","2","3"));
//    }
}

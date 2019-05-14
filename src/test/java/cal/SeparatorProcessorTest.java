package cal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SeparatorProcessorTest {
    @Test
    void 구분자_식_나누기(){
        String inputString = "//.;[₩n1;2;3";
        assertThat(SeparatorProcessor.inputSeparate(inputString)).isEqualTo(new String[]{".;[","1;2;3"});
    }

   
}

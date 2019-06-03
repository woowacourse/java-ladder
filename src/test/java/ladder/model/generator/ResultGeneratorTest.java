package ladder.model.generator;

import ladder.model.Result;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultGeneratorTest {

    @Test
    void Results_생성() {
        List<Result> results = ResultsGenerator.generateResults(new String[]{"pobi", "crong", "honux", "jk"});
        assertThat(results).isEqualTo(Arrays.asList(new Result("pobi"), new Result("crong"),
                                       new Result("honux"), new Result("jk")));
    }
}

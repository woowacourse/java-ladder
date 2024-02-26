package domain.result;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ResultsTest {
    @Test
    void Results는_인덱스에_해당하는_Result를_반환한다() {
        Results results = new Results(List.of(
                new Result("꽝1"),
                new Result("꽝2"),
                new Result("꽝3")));

        Result foundResult = results.findResultByIndex(1);
        assertEquals("꽝2", foundResult.getValue());
    }
}

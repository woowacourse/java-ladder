package ladder.domain.result;

import java.util.ArrayList;
import java.util.List;

public class ResultGenerator {
    public static List<Result> generate(List<String> results) {
        List<Result> resultGroup = new ArrayList<>();
        for (String result : results) {
            resultGroup.add(new Result(result));
        }
        return resultGroup;
    }
}

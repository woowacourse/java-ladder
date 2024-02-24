package view;

import java.util.ArrayList;
import java.util.List;

public class ClimbResultPrinter {
    public static List<String> of(List<String> rawNames, List<String> rawResults) {
        List<String> climbResults = new ArrayList<>();
        for (int index = 0; index < rawNames.size(); index++) {
            String rawName = rawNames.get(index);
            String rawResult = rawResults.get(index);
            String result = "%s : %s".formatted(rawName, rawResult);
            climbResults.add(result);
        }
        return climbResults;
    }
}

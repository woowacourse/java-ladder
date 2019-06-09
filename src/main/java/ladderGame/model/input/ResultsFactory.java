package ladderGame.model.input;

import java.util.List;

public class ResultsFactory {
    public static Results getResults(List<String> splittedInput, int playersSize) {
        Results results = new Results(splittedInput, playersSize);
        return results;
    }
}

package laddergame.view;

import laddergame.domain.Name;
import laddergame.domain.Result;

import java.util.ArrayList;
import java.util.Map;

public enum LadderMatchForm {
    SEPARATE(" : ");

    private static final int ONE_MATCH_RESULT_SIZE = 1;

    private final String unit;

    LadderMatchForm(String unit) {
        this.unit = unit;
    }

    public static String joinUnitsFrom(final Map<Name, Result> matchResults) {
        if (matchResults.size() > ONE_MATCH_RESULT_SIZE) {
            return createMatchForms(matchResults);
        }
        final Result result = createOneMatchForm(matchResults);
        return result.getValue();
    }

    private static String createMatchForms(final Map<Name, Result> matchResults) {
        final StringBuilder matchBuilder = new StringBuilder();
        if (matchResults.size() > ONE_MATCH_RESULT_SIZE) {
            matchResults.forEach((name, result) ->
                    matchBuilder.append(name.getValue())
                            .append(SEPARATE.unit)
                            .append(result.getValue())
                            .append(System.lineSeparator()));
        }
        return matchBuilder.toString();
    }

    private static Result createOneMatchForm(final Map<Name, Result> matchResults) {
        return new ArrayList<>(matchResults.values()).get(0);
    }
}

package laddergame.view;

import laddergame.domain.LadderMatchResults;

public enum LadderMatchForm {
    SEPARATE(" : ");

    private final String unit;

    LadderMatchForm(String unit) {
        this.unit = unit;
    }

    public static String joinUnitsFrom(final LadderMatchResults matchResults) {
        if (matchResults.hasSizeGreaterThanOne()) {
            return createMatchForms(matchResults);
        }
        return createOneMatchForm(matchResults);
    }

    private static String createMatchForms(final LadderMatchResults matchResults) {
        final StringBuilder matchBuilder = new StringBuilder();
        matchResults.getMatchResults()
                .forEach((name, result) ->
                        matchBuilder.append(name.getValue())
                                .append(SEPARATE.unit)
                                .append(result.getValue())
                                .append(System.lineSeparator()));
        return matchBuilder.toString();
    }

    private static String createOneMatchForm(final LadderMatchResults matchResults) {
        return matchResults.getFirstMatchResult().getValue();
    }
}

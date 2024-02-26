package laddergame.view;

import java.util.List;
import java.util.stream.Collectors;
import laddergame.dto.LadderResult;
import laddergame.dto.MatchingResult;

public class OutputView {

    public void printLadderResult(final LadderResult ladderResult) {
        System.out.println(
                "실행결과" + System.lineSeparator() +
                        NameFormatter.formatNames(ladderResult.names()) + System.lineSeparator() +
                        LadderFormatter.formatLadder(ladderResult) + System.lineSeparator() +
                        formatResults(ladderResult.results())
        );
    }

    public void printExceptionMessage(final String message) {
        System.out.println(message);
    }

    public void printMatchingResults(final List<MatchingResult> matchingResults) {
        System.out.println("실행 결과");
        matchingResults.forEach(
                matchingResult -> System.out.printf("%s : %s%n", matchingResult.name(), matchingResult.result()));
    }

    public void printMatchingResult(final String result) {
        System.out.println("실행 결과");
        System.out.println(result);
    }

    private String formatResults(final List<String> results) {
        return results.stream()
                .map(result -> String.format("%-6s", result))
                .collect(Collectors.joining());
    }
}

package ladder.view;

import static java.util.stream.Collectors.joining;

import java.util.List;
import ladder.domain.Step;
import ladder.dto.LadderResponse;
import ladder.dto.PlayerResultResponse;

public class OutputView {

    private OutputView() {
    }

    public static void printLadderResult(LadderResponse ladderResponse) {
        System.out.println("\n사다리 결과");
        printNames(ladderResponse.getPlayerNames());
        printLadder(ladderResponse.getLines());
        printPrizes(ladderResponse.getPrizeNames());
    }

    private static void printNames(List<String> playerNames) {
        playerNames.stream()
                .map(name -> String.format("%-5s ", name))
                .forEach(System.out::print);
        System.out.println();
    }

    private static void printLadder(List<List<Step>> lines) {
        lines.stream()
                .map(OutputView::stepsToString)
                .forEach(System.out::println);
    }

    private static String stepsToString(List<Step> steps) {
        return "|" + steps.stream()
                .map(OutputView::stepToString)
                .collect(joining("|")) + "|";
    }

    private static String stepToString(Step step) {
        if (step == Step.EXIST) {
            return "-----";
        }
        if (step == Step.EMPTY) {
            return "     ";
        }
        throw new UnsupportedOperationException("[ERROR] 처리할 수 없는 Step 입니다.");
    }

    private static void printPrizes(List<String> prizes) {
        prizes.stream()
                .map(prize -> String.format("%-5s ", prize))
                .forEach(System.out::print);
        System.out.println();
    }

    public static void printAllPlayerResults(List<PlayerResultResponse> playerResults) {
        System.out.println();
        System.out.println("실행 결과");
        playerResults.stream()
                .map(response -> response.getPlayerName() + " : " + response.getPlayerPrize())
                .forEach(System.out::println);
    }

    public static void printPlayerResult(PlayerResultResponse result) {
        System.out.println();
        System.out.println("실행 결과");
        System.out.println(result.getPlayerPrize());
    }

    public static void printError(String message) {
        System.out.println(message);
    }
}

package ladder.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import ladder.dto.response.LadderAllResultsResponse;
import ladder.dto.response.ladder.LadderResponse;
import ladder.dto.response.ladder.FloorResponse;
import ladder.dto.response.player.PlayerResponse;
import ladder.dto.response.player.PlayersResponse;
import ladder.dto.response.prize.PrizeResponse;
import ladder.dto.response.prize.PrizesResponse;

public class OutputView {
    private static final String LADDER_LEFT_MARGIN = "    ";
    private static final String LADDER_RUNG_EMPTY = "     ";
    private static final String LADDER_RUNG_EXIST = "-----";
    private static final String LADDER_SIDE_RAIL = "|";
    private static final String ERROR_PREFIX = "[ERROR]";

    public void printErrorMessage(String message) {
        System.out.printf("%s %s%n", ERROR_PREFIX, message);
    }

    public void printLadderResult(PlayersResponse playersResponse,
                                  LadderResponse ladderResponse,
                                  PrizesResponse prizesResponse) {
        printLadderResultMessage();
        printPlayerNames(playersResponse);
        printLadder(ladderResponse);
        printPrizeNames(prizesResponse);
    }

    public void printLadderResultMessage() {
        System.out.println();
        System.out.println("실행결과");
    }

    public void printPlayerNames(PlayersResponse playersResponse) {
        List<String> playerNames = playersResponse.playerResponses().stream()
                .map(PlayerResponse::name)
                .toList();

        String playerNamesMessage = playerNames.stream()
                .map(this::generateNameMessage)
                .collect(Collectors.joining());

        System.out.println();
        System.out.println(playerNamesMessage);
    }

    private String generateNameMessage(String playerName) {
        return String.format("%5s ", playerName);
    }

    private void printLadder(LadderResponse ladderResponse) {
        String ladderMessage = generateLadderMessage(ladderResponse.floorResponses());

        System.out.println(ladderMessage);
    }

    private String generateLadderMessage(List<FloorResponse> floorResponses) {
        return floorResponses.stream()
                .map(floorResponse -> generateLadderFloor(floorResponse.rungsExist()))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String generateLadderFloor(List<Boolean> rungsExist) {
        String ladderFloorMessage = rungsExist.stream()
                .map(this::generateRungMessage)
                .collect(Collectors.joining(LADDER_SIDE_RAIL, LADDER_SIDE_RAIL, LADDER_SIDE_RAIL));

        return LADDER_LEFT_MARGIN.concat(ladderFloorMessage);
    }

    private String generateRungMessage(boolean rungExist) {
        if (rungExist) {
            return LADDER_RUNG_EXIST;
        }
        return LADDER_RUNG_EMPTY;
    }

    public void printPrizeNames(PrizesResponse prizesResponse) {
        List<String> prizeNames = prizesResponse.prizeResponses().stream()
                .map(PrizeResponse::name)
                .toList();

        String prizeNamesMessage = prizeNames.stream()
                .map(this::generateNameMessage)
                .collect(Collectors.joining());

        System.out.println(prizeNamesMessage);
    }

    public void printPrizeForSelectedPlayer(PrizeResponse prizeResponse) {
        String prizeName = prizeResponse.name();

        System.out.println();
        System.out.println("실행결과");
        System.out.println(prizeName);
    }

    public void printAllResults(LadderAllResultsResponse ladderAllResultsResponse) {
        Map<String, String> allResults = ladderAllResultsResponse.allResults();
        String resultFormat = "%s : %s%n";

        System.out.println();
        System.out.println("실행결과");
        allResults.forEach(
                (playerName, prizeName) -> System.out.printf(resultFormat, playerName, prizeName)
        );
    }
}

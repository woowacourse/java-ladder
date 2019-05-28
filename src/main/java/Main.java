import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class Main {
    private static final String EMPTY = "";

    public static void main(String[] args) {
        Players players = readPlayers(EMPTY);
        Rewards rewards = readRewards(EMPTY, players.size());
        Height height = Height.create(InputView.readHeight());

        LadderBoard ladderBoard = LadderBoard.of(Ladder.create(height, players.size()), players, rewards);
        OutputView.printLadderBoard(ladderBoard);

        keepLadderBoardMatching(ladderBoard.play(), players);
    }

    private static void keepLadderBoardMatching(GameResult gameResult, Players players) {
        while (MatchingCommand.FINISHED != tryLadderBoardMatching(gameResult, players)) ;
    }

    private static MatchingCommand tryLadderBoardMatching(GameResult gameResult, Players players) {
        PlayerWithMatchingCommand playerWithMatchingCommand = readExistPlayer(EMPTY, players);
        if (playerWithMatchingCommand.isFinished()) {
            return MatchingCommand.FINISHED;
        }
        Player player = playerWithMatchingCommand.getPlayer();
        if (player.equals(Player.ALL)) {
            OutputView.printLadderMachingResults(gameResult, players.toList());
        } else {
            OutputView.printLadderMachingResult(gameResult, player);
        }
        return MatchingCommand.GOING;
    }

    private static Players readPlayers(String notifyingMessage) {
        List<String> names = InputView.readPlayers(notifyingMessage);

        try {
            return Players.from(names);
        } catch (IllegalArgumentException e) {
            return readPlayers(e.getMessage());
        } catch (DuplicatedNameException e) {
            return readPlayers(e.getMessage());
        }
    }

    private static Rewards readRewards(String notifyingMessage, int numPlayers) {
        List<String> names = InputView.readRewards(notifyingMessage);
        try {
            return createRewards(names, numPlayers);
        } catch (IllegalArgumentException e) {
            return readRewards(e.getMessage(), numPlayers);
        }
    }

    private static Rewards createRewards(List<String> splitNames, int numPlayers) {
        if (splitNames.size() != numPlayers) {
            throw new IllegalArgumentException("플레이어 수와 보상의 수가 다릅니다.");
        }
        return Rewards.from(splitNames);
    }

    private static PlayerWithMatchingCommand readExistPlayer(String notifyingMessage, Players players) {
        String name = InputView.readExistPlayer(notifyingMessage);
        if (name.equals(InputView.MATCHING_FINISHED_MESSAGE)) {
            return PlayerWithMatchingCommand.of(Player.NONE, MatchingCommand.FINISHED);
        }
        try {
            return PlayerWithMatchingCommand.of(createExistPlayer(name, players), MatchingCommand.GOING);
        } catch (IllegalArgumentException e) {
            return readExistPlayer(e.getMessage(), players);
        }
    }

    private static Player createExistPlayer(String name, Players players) {
        Player player = Player.from(name);
        if (!player.equals(Player.ALL) && !players.contains(player)) {
            throw new IllegalArgumentException("존재하지 않는 플레이어 입니다. 다시입력해주세요.");
        }
        return player;
    }
}

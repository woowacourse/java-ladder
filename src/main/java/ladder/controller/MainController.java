package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class MainController {

    public static void main(String[] args) {
        try {
            final LadderGame ladderGame = makeLadderGameByConsole();
            OutputView.printLadderGame(ladderGame);
            getUserAndPrint(ladderGame);
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }

    private static void getUserAndPrint(final LadderGame ladderGame) {
        PrintCommand command = PrintCommand.PRINT_ONE;
        while (command == PrintCommand.PRINT_ONE) {
            final String rewardedUser = InputView.inputRewardedUser();
            command = PrintCommand.of(rewardedUser);
            controlPrintReward(ladderGame, command, rewardedUser);
        }
    }

    private static void controlPrintReward(final LadderGame ladderGame, final PrintCommand command, final String userName) {
        if (PrintCommand.PRINT_ONE == command) {
            OutputView.printReward(ladderGame.getRewardOf(userName));
            return;
        }
        OutputView.printResult(ladderGame.getGameResultDto());
    }

    private static LadderGame makeLadderGameByConsole() {
        Users users = inputUsers();
        Ladder ladder = inputLadder(users);
        ladder.makeFloors(new RandomLineSourceGenerator());
        Reward reward = new Reward(InputView.inputReward());
        return new LadderGame(ladder, users, reward);
    }

    private static Ladder inputLadder(Users users) {
        try {
            return new Ladder(InputView.inputFloorHeight(), users.size());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputLadder(users);
        }
    }

    private static Users inputUsers() {
        try {
            return new Users(InputView.inputUserNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputUsers();
        }
    }
}

package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.RandomNumberGenerator;
import ladder.domain.Users;
import ladder.view.InputView;
import ladder.view.OutputView;

public class MainController {

    public static void main(String[] args) {

        Users users = inputUsers();
        Ladder ladder = inputLadder(users);
        ladder.makeFloors(new RandomNumberGenerator());
        OutputView.printResult(users, ladder);
    }

    private static Ladder inputLadder(Users users) {

        try {
            return new Ladder(InputView.inputFloorHeight(), users);
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

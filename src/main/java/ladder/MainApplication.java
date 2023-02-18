package ladder;

import ladder.domain.Ladder;
import ladder.domain.Users;
import ladder.domain.generator.RandomPointGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class MainApplication {

    public static void main(String[] args) {

        Users users = inputUsers();
        Ladder ladder = createLadder(users);
        OutputView.printLadder(users, ladder);
    }

    private static Users inputUsers() {

        try {
            return new Users(InputView.inputUserNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputUsers();
        }
    }

    private static Ladder createLadder(Users users) {

        try {
            return new Ladder(InputView.inputFloorHeight(), users, new RandomPointGenerator());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createLadder(users);
        }
    }
}

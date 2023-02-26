package controller;

import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.user.User;
import domain.user.Users;
import dto.ladder.LadderDto;
import dto.user.UsersDto;
import java.util.ArrayList;
import java.util.List;
import utils.RandomBooleanGenerator;
import view.InputView;
import view.OutputView;

public class LadderGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private Users users;
    private Ladder ladder;

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void initialize() {
        users = initializeUsers();
        ladder = new Ladder(users.getPersonCount(), initializeHeight(), new RandomBooleanGenerator());
    }

    public void run() {
        outputView.printLadderGameResult(UsersDto.from(users), LadderDto.from(ladder));
    }

    private Users initializeUsers() {
        try {
            List<String> userNames = inputView.inputUserName();
            return new Users(createUsers(userNames));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return initializeUsers();
        }
    }

    private List<User> createUsers(List<String> userNames) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < userNames.size(); i++) {
            users.add(new User(userNames.get(i), i));
        }
        return users;
    }

    private Height initializeHeight() {
        try {
            return new Height(inputView.inputLadderHeight());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return initializeHeight();
        }
    }
}

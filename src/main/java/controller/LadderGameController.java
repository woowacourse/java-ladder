package controller;

import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.prize.Prize;
import domain.prize.Prizes;
import domain.result.Result;
import domain.result.Search;
import domain.user.User;
import domain.user.Users;
import dto.ladder.LadderDto;
import dto.ladder.LineDto;
import dto.prize.PrizesDto;
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
    private Prizes prizes;
    private Result result;

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void initialize() {
        users = initializeUsers();
        int width = users.getPersonCount();
        prizes = initializePrizes(width);
        ladder = new Ladder(width, initializeHeight(), new RandomBooleanGenerator());
    }

    public void run() {
        UsersDto usersDto = UsersDto.from(users);
        outputView.printLadderGameResult(usersDto, LadderDto.from(ladder), PrizesDto.from(prizes));
        result = new Result(usersDto.getUserNames());
        searchResult(usersDto);
    }

    private void searchResult(UsersDto usersDto) {
        Search search = initializeSearch(usersDto);
        String searchName = search.getSearchName();
        checkAllKeyword(usersDto, searchName);
    }

    private void checkAllKeyword(UsersDto usersDto, String searchName) {
        if (!searchName.equals("all")) {
            checkMoved(searchName);
            outputView.printOneResult(result.findOneResult(searchName));
            searchResult(usersDto);
        }
        if (searchName.equals("all")) {
            List<String> searchNames = UsersDto.from(users).getUserNames();
            outputView.printAllResult(searchNames, moveAllUser(searchNames));
        }
    }

    private List<String> moveAllUser(List<String> searchNames) {
        List<String> results = new ArrayList<>();
        for (String searchName : searchNames) {
            checkMoved(searchName);
            results.add(result.findOneResult(searchName));
        }
        return results;
    }

    private void checkMoved(String searchName) {
        if (result.findOneResult(searchName) == null) {
            moveUserToPrize(searchName);
        }
    }

    private void moveUserToPrize(String searchName) {
        User searchUser = users.findUserByUserName(searchName);
        for (LineDto lineDto : ladder.getLines()) {
            searchUser.getPosition().movePosition(lineDto.getLine());
        }
        result.saveResult(searchName, prizes.getPrizeNames().get(searchUser.getPosition().getValue()));
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

    private Prizes initializePrizes(int width) {
        try {
            List<String> prizeNames = inputView.inputPrizeName();
            return new Prizes(createPrizes(prizeNames), width);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return initializePrizes(width);
        }
    }

    private List<Prize> createPrizes(List<String> prizeNames) {
        List<Prize> prizes = new ArrayList<>();
        for (String prizeName : prizeNames) {
            prizes.add(new Prize(prizeName));
        }
        return prizes;
    }

    private Search initializeSearch(UsersDto usersDto) {
        try {
            return new Search(inputView.inputSearchName(), usersDto.getUserNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return initializeSearch(usersDto);
        }
    }
}

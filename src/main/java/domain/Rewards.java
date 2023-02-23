package domain;

import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Rewards {
    private static final String REWARDS_SIZE_ERROR_MESSAGE = "[ERROR] 플레이어 수에 맞는 실행 결과를 입력해주세요.";
    private static final String DELIMITER = ",";

    private final List<Reward> rewards;
    private final InputView inputView;

    public Rewards(String inputRewards, int minSize, InputView inputView) {
        inputRewards = validateRewards(inputRewards, minSize, inputView);
        this.rewards = new ArrayList<>();
        this.inputView = inputView;
        createRewards(inputRewards);
    }

    private String validateRewards(String inputRewards, int minSize, InputView inputView) {
        try {
            validateSize(inputRewards, minSize);
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception.getMessage());
            inputRewards = validateRewards(inputView.readRewards(), minSize, inputView);
        }
        return inputRewards;
    }

    private void validateSize(String inputRewards, int minSize) {
        if (List.of(inputRewards.split(DELIMITER)).size() != minSize) {
            throw new IllegalArgumentException(REWARDS_SIZE_ERROR_MESSAGE);
        }
    }

    private void createRewards(String inputRewards) {
        for (String input : List.of(inputRewards.split(DELIMITER))) {
            this.rewards.add(new Reward(input));
        }
    }

    public List<Reward> getRewards() {
        return rewards;
    }
}

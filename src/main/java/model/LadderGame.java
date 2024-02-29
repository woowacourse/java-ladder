package model;

import java.util.Arrays;
import java.util.List;

public class LadderGame {

    private static final String DELIMITER = ",";

    private final People people;
    private final Ladder ladder;
    private final RewardBoard rewardBoard;

    public LadderGame(People people, Ladder ladder, String originPrizeInput) {
        this.people = people;
        this.ladder = ladder;
        this.rewardBoard = new RewardBoard();
        calculatePrizes(parsePrizes(originPrizeInput));
    }

    private List<Prize> parsePrizes(String originPrizeInput) {
        return Arrays.stream(originPrizeInput.split(DELIMITER))
                .map(Prize::new)
                .toList();
    }

    private void calculatePrizes(List<Prize> orderedPrize) {
        people.getParticipants()
                .forEach(participant -> calculateIndividualPrize(participant, orderedPrize));
    }

    private void calculateIndividualPrize(Person person, List<Prize> orderedPrize) {
        Position position = findInitialPosition(person);
        goDownOneself(position);
        Prize selectedPrize = orderedPrize.get(position.getHorizontal());
        rewardBoard.addReward(person, selectedPrize);
    }

    private void goDownOneself(Position position) {
        while(position.getVertical() >= 0) {
            Direction nextHorizontalPath = ladder.findNextHorizontalPath(position.getHorizontal(),
                    position.getVertical());
            position.moveHorizontally(nextHorizontalPath);
            position.moveToDownStair();
        }
    }

    private Position findInitialPosition(Person person) {
        int initialHorizontalIndex = people.findInitialIndex(person);
        int initialVerticalIndex = ladder.getHeightValue()-1;
        return new Position(initialHorizontalIndex, initialVerticalIndex);
    }

    public RewardBoard getRewardBoard() {
        return rewardBoard;
    }
}

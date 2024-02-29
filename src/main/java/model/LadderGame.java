package model;

public class LadderGame {

    private static final String DELIMITER = ",";

    private final People people;
    private final Ladder ladder;
    private final RewardBoard rewardBoard;

    public LadderGame(People people, Ladder ladder, String originPrizeInput) {
        this.people = people;
        this.ladder = ladder;
        this.rewardBoard = new RewardBoard();
        calculatePrizes(new Prizes(originPrizeInput));
    }

    private void calculatePrizes(Prizes inputOrderedPrizes) {
        people.getParticipants()
                .forEach(participant -> calculateIndividualPrize(participant, inputOrderedPrizes));
    }

    private void calculateIndividualPrize(Person person, Prizes orderedPrizes) {
        Position position = findInitialPosition(person);
        goDownOneself(position);
        Prize selectedPrize = orderedPrizes.findPrizeByIndex(position.getHorizontal());
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

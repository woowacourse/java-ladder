package model;

public class LadderGame {
    private final People people;
    private final Ladder ladder;
    private final RewardBoard rewardBoard;

    public LadderGame(People people, Ladder ladder, String originPrizeInput) {
        this.people = people;
        this.ladder = ladder;
        this.rewardBoard = new RewardBoard();
        calculatePrizes(new Prizes(originPrizeInput, people.getParticipantsSize()));
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
        while(isWalkingTightrope(position)) {
            Direction nextHorizontalPath = ladder.findNextHorizontalPath(position.getHorizontal(),
                    position.getVertical());
            position.moveHorizontally(nextHorizontalPath);
            position.moveToDownStair();
            System.out.println();
        }
    }

    private boolean isWalkingTightrope(Position position) {
        return position.getVertical() < ladder.getHeightValue();
    }

    private Position findInitialPosition(Person person) {
        int initialHorizontalIndex = people.findInitialIndex(person);
        int initialVerticalIndex = 0;
        return new Position(initialHorizontalIndex, initialVerticalIndex);
    }

    public RewardBoard getRewardBoard() {
        return rewardBoard;
    }

    public People getPeople() {
        return people;
    }
}

package ladder.domain;

public class LadderGameData {
    private final Person person;
    private final LadderRewards ladderRewards;
    private final int height;

    public LadderGameData(final Person person, final LadderRewards ladderRewards) {
        this(person, ladderRewards, 1);
    }

    public LadderGameData(final Person person, final LadderRewards ladderRewards, final int height) {
        this.person = person;
        this.ladderRewards = ladderRewards;
        this.height = height;
    }

    public Person getPerson() {
        return person;
    }

    public LadderRewards getLadderRewards() {
        return ladderRewards;
    }

    public int getHeight() {
        return height;
    }
}
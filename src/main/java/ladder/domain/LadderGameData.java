package ladder.domain;

public class LadderGameData {
    private final Person person;
    private final Result result;
    private final int height;

    public LadderGameData(final Person person, final Result result, final int height) {
        this.person = person;
        this.result = result;
        this.height = height;
    }

    public Person getPerson() {
        return person;
    }

    public Result getResult() {
        return result;
    }

    public int getHeight() {
        return height;
    }
}